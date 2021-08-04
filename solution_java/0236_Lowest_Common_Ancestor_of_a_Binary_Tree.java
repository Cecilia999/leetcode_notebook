// 题目大意
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
// 百度百科中最近公共祖先的定义为：
// “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
// 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出：3
// 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

// 解题思路
// 先序遍历，左子树->右子树->根节点
// 若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：
// 1. p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
// 2. p = root ，且 q 在 root 的左或右子树中；
// 3. q = root ，且 p 在 root 的左或右子树中；

// 通过递归对二叉树进行先序遍历，当遇到节点 p 或 q 时返回。
// 从底至顶回溯，当节点 p, q 在节点 root 的异侧时，节点 root 即为最近公共祖先，则向上返回 root 。

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q)
            return root;
        
        if(root!=null){
            TreeNode left = lowestCommonAncestor(root.left, p, q); //在左子树中搜索p,q
            TreeNode right = lowestCommonAncestor(root.right, p, q); //在右子树中搜索p,q
            
            //p和q分别在当前root的左子树和右子树
            if(left!=null && right!=null) 
                return root;
            
            //p或q在当前root的左子树
            //可能p和q都在root的左子树 or 只有一个在root的左子树
            if(left!=null)
                return left;
            //同理右子树
            else if(right!=null)
                return right;
        }
        
        return null; //如果当前 左/右子树 都没有 p/q 则返回null
    }
}