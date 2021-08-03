// 题目大意
// 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
// 就是给你个形状未知的二叉树，找出每一层的最右节点

// 解题思路
// dfs+层数+从右子树展开搜索

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
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        //dfs深度搜索，找到每一层最右的node
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int depth){
        if(root==null) return;
        
        //第一次深度搜索到这一层
        if(depth == res.size()){
            res.add(root.val);
        }
        
        //先搜索右子树
        if(root.right!=null) dfs(root.right, depth+1);
        if(root.left!=null)  dfs(root.left, depth+1);
    }
}