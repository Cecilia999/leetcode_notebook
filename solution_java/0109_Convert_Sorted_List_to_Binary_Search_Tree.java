// 题目大意 #
// 将链表转化为高度平衡的二叉搜索树。高度平衡的定义：每个结点的 2 个子结点的深度不能相差超过 1 。

// 解题思路 #
// 看到ascending order 依旧是二分法
// linked list 实现二分法：
// 利用快慢指针，fast pt每次走两步，slow每次走一步，当fast到达链尾(null)时，slow正好在链表的中间

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return sortListHelper(head, null);
    }
    
    public TreeNode sortListHelper(ListNode head, ListNode tail){
        //when to stop recursion
        if(head==tail) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        //find mid node 
        while( fast!=tail && fast.next!=tail ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortListHelper(head, slow);
        root.right = sortListHelper(slow.next, tail);
        
        return root;
    }
}