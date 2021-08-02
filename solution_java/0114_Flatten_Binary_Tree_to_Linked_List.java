// 给你二叉树的根结点 root ，请你将它展开为一个单链表：

// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。

// 输入：root = [1,2,5,3,4,null,6]
// 输出：[1,null,2,null,3,null,4,null,5,null,6]

// 解题思路
// 用stack 前序遍历

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
    public void flatten(TreeNode root) {   
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        //注意pre不要一开始就initialize = root
        TreeNode pre = null;
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(pre!=null){
                pre.left = null;
                pre.right = curr;
            }
           
            pre = curr;
            
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
            
        }
        
    }
}