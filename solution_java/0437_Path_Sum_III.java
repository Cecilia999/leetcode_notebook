// 题目大意
// 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

// 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// 输出：3
// 解释：和等于 8 的路径有 3 条，如图所示。

// 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// 输出：3

// 二叉树的节点个数的范围是 [0,1000]
// -109 <= Node.val <= 109 
// -1000 <= targetSum <= 1000

// 解题思路
// 遍历每个node+dfs寻找路径和==targetsum的路径，和113题一样必须遍历到叶子结点才结束
// 时间复杂度不稳定 O(n^2)~O(nlogn)如果是完全平衡二叉树

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
    private static int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
    
        //遍历每条路径的起始点
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    //计算路径
    private int dfs(TreeNode root, int sum){
        int res = 0;
        if(root==null)
            return res;
        
        //不要找到一个root.val==sum就return，因为node.val可能是负数，应该遍历到叶子结点才结束
        if(root.val==sum)
            res++;     

        res += dfs(root.left, sum-root.val); 
        res += dfs(root.right, sum-root.val);   
        return res;
    }
}