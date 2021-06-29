// 题目大意
// 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
// s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

//思路：给出 2 棵树 s 和 t，要求判断 s 是否是 t 的子树
//这道题有三种情况
//1. subtree和tree完全一样 就等于100题的判断是不是same tree
//2. subtree是t左子树中的子树
//3. subtree是t右子树中的子树

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        if(isSameTree(root, subRoot))
            return true;
        else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);        
        }
    }
    
    public boolean isSameTree(TreeNode root, TreeNode sub){
        if(root==null && sub==null){
            return true;
        }
        else if(root!=null && sub!=null){
            if(root.val == sub.val)
                return isSameTree(root.left, sub.left) && isSameTree(root.right, sub.right);
            else 
                return false;
        }
        else{
            return false;
        }
    }
}