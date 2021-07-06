// 题目大意
// 返回一个bst中第k小的值

//解题思路
//inorder traversal for bst using stack
//inorder traversal 就是按照从小到大的顺序traversal整个bst的

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            //decrement k first!
            k--;
            if(k==0) break;
            root = root.right;
        }
        
        return root.val;
    }
}
