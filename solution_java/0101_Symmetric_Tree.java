// 题目大意 #
// 这一题要求判断 2 颗树是否是左右对称的。

// 解题思路 #
// 这道题是几道题的综合题。将根节点的左字数反转二叉树，然后再和根节点的右节点进行比较，是否完全相等。
// 反转二叉树是第 226 题。判断 2 颗树是否完全相等是第 100 题。
// 或者直接recursion

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return SymmertricHelper(root.left, root.right);
    }
    
    public boolean SymmertricHelper(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return SymmertricHelper(left.left, right.right)&&SymmertricHelper(left.right, right.left);
    }
}