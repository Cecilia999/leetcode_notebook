//题目大意 
// 输出链表中间结点。
// 如果链表长度是奇数，输出中间结点是中间结点。如果链表长度是双数，输出中间结点是中位数后面的那个结点。

// 解题思路: two pointer
// 用 2 个指针只遍历一次就可以找到中间节点。一个指针每次移动 2 步，另外一个指针每次移动 1 步，
// 当快的指针走到终点的时候，慢的指针就是中间节点。

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
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}