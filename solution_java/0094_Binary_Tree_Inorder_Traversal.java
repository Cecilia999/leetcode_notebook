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

 //方法1 inorder traversal for bst using stack
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        
        
        return list;
    }
}

//方法2 using recursion
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<Integer>();
      traversal(root, list);
      return list;
  }
  
  private void traversal(TreeNode root, List<Integer> list){
      if(root==null){
          return;
      }
      traversal(root.left, list);
      list.add(root.val);
      traversal(root.right, list);   
      
  }
}