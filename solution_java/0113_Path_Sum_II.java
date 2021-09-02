// 题目大意
// 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。

// 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// 输出：[[5,4,11,2],[5,8,4,5]]

// 输入：root = [1,2,3], targetSum = 5
// 输出：[]

// 输入：root = [1,2], targetSum = 0
// 输出：[]

//解题思路
// dfs+回溯
// 判断停止递归的条件一定是到达了叶子结点
// 加入list的条件是当前点是叶子节点且路径和==targetsum
// 退出当前路径需要remove节点

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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> pathList = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int target){
        if(root==null)
            return;

        pathList.add(root.val);
        target -= root.val;
        if(root.left==null && root.right==null && target==0)
            res.add(new ArrayList<Integer>(pathList));
        

        dfs(root.left, target);
        dfs(root.right, target);
        pathList.remove(pathList.size()-1);
    }
}