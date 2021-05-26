//没想明白。。。

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
  public List<TreeNode> generateTrees(int n) {
      return generateTreeList(1, n);
  }
  
  private List<TreeNode> generateTreeList(int start, int end){
      List<TreeNode> list = new ArrayList<TreeNode>();
      if(start>end)
          list.add(null);
      
      for(int index=start; index<=end; index++){
          //先得到left sub tree & right sub tree
          //把他们和由root合并起来
          
          List<TreeNode> leftTree = generateTreeList(start, index-1);
          List<TreeNode> rightTree = generateTreeList(index+1, end);
          for (TreeNode left : leftTree) {
              for(TreeNode right: rightTree) {
                  TreeNode root = new TreeNode(index);
                  root.left = left;
                  root.right = right;
                  list.add(root);                 
              }
          }
          //System.out.println(leftTree + "\n");
      }
      
      return list;
  }
  
}