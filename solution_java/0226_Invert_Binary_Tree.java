//题目大意
//翻转一棵二叉树。

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

 //从上到下，直接翻转左右子树
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        
        //用一个TreeNode temp交换就可以了
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = right;
        root.right = left;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}