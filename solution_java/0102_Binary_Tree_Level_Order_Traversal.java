// 题目大意 #
// 按层序从上到下每层从左到右遍历一颗树。

// 解题思路 #
// 用depth manage层数，层层遍历

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(root, res, 0);
        return res;
    }
    
    public void levelHelper(TreeNode root, List<List<Integer>> res, int depth){
        if(root!=null){
            //当当前层数大于res的size的时候，加一层到res
            if(depth>=res.size())
                res.add(new ArrayList<Integer>());
            res.get(depth).add(root.val);
            levelHelper(root.left, res, depth+1);
            levelHelper(root.right, res, depth+1);
        }
        return;
    }
}