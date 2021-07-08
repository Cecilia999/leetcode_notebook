// 题目大意 #
// 要求输出一棵树的最大高度。

// 解题思路 #
// 这一题递归遍历就可，遍历根节点的左孩子的高度和根节点右孩子的高度，取出两者的最大值再加一即为总高度。

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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}