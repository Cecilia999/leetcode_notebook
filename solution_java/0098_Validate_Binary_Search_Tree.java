// 题目大意 #
// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。假设一个二叉搜索树具有如下特征：

// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。

// 解题思路 #
// inorder iterative traversal for BST using stack
// 判断是不是 validate bst using inorder traversal 主要的思路就是 maintain pre node, 比较 pre.val 和 root.val
// 因为inorder traversal正好是按照从小到大的顺序

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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            
            root=stack.pop();
            if(pre!=null && pre.val>=root.val) return false;
            pre = root;
            root = root.right;
        }
        
        return true;
    }
}