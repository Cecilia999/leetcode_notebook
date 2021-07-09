// 题目大意 #
// 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。说明: 叶子节点是指没有子节点的节点。

// 解题思路 #
// 递归求解即可
//注意空数with targetsum=0 should return false

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return (targetSum-root.val) == 0;
        else{
            return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
        }
    }
}