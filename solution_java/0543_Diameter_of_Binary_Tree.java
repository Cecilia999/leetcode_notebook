// 题目大意
// 给定一棵二叉树，你需要计算它的直径长度。
// 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//    1
//   / \
//  2   3
// / \     
// 4   5    
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

// 解题思路
// 这题和124. Binary Tree Maximum Path Sum 一样
// 对于每个节点，深度搜索左子树和右子树，当前节点的最长路径为left+right+1
// 对于当前路径的父节点，能够提供的最长路径为1 + max(left, right)

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
    private int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxLen-1;  //edge = node数-1
    }

    private int dfs(TreeNode root){
        if(root==null) 
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        maxLen = Math.max(maxLen, left+right+1);

        return 1 + Math.max(left, right);
    }
}