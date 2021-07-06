// 题目大意 #
// 二叉搜索树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
// （这两个节点不一定相连）

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

//思路是用中根遍历(in-order traversal) 中根遍历的情况下，node.value一定是从小到大的顺序排列的
//用三个treenode
//pre 代表按照大小顺序当前root的前一个
//first代表第一个找到的值比他的下一个要大的node
//second表示第二找到的不在正确位置上的node，即在first已经存在的情况下 prev
//交换两个node的val就行

class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        first=null;
        second=null;
        prev=null;
        
        travel(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }
    
    private void travel(TreeNode root){
        if(root==null) return;
        
        travel(root.left);
        
        if(first==null && (prev==null ||  prev.val>=root.val))
            first = prev;
        if(first!=null  &&  prev.val>=root.val){
            second  = root;
        }
        prev=root;
        travel(root.right);
    }
}