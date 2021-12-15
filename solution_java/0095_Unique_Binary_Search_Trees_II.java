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

//I think the key idea of construct unique bst is
// F(i, n) = G(i-1) * G(n-i)
// 长度为n，以i为root的bst是由
//left tree = 长度为i-1，有i-1个possible root + 
//right tree = 长度为n-i，有n-i个possible root组成的

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = generateTree(1, n);
        return res;
    }
    
    public List<TreeNode> generateTree(int start, int end){
        List<TreeNode> subtree = new ArrayList<>();
        
        if(start>end){
            subtree.add(null);
            return subtree;
        }
        
        for(int i=start; i<=end; i++){
            List<TreeNode> leftTree = generateTree(start, i-1);
            List<TreeNode> rightTree = generateTree(i+1, end);
            
            for(TreeNode leftNode : leftTree){
                for(TreeNode rightNode : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    
                    subtree.add(root);
                }
            }
        }
        
        return subtree;
    }
}