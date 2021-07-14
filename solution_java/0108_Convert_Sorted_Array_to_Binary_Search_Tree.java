// 题目大意 #
// 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

//解题思路
//height-balance binary tree 需要对数组二分法处理才能保证左子树<根<右子树

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        
        return sortHelper(nums, 0, nums.length-1);
    }
    
    public TreeNode sortHelper(int[] nums, int start, int end){
        //when to start recursion
        if(start>end)
            return null;
        
        int mid = start+(end-start)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortHelper(nums, start, mid-1);
        root.right = sortHelper(nums, mid+1, end);
        
        return root;
    }
}