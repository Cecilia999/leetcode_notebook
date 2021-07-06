// 题目大意 #
// 按层序从上到下zigzag的遍历一颗树。

// 解题思路 #
// 用depth manage层数，层层遍历
// 用层的奇偶数来处理放入的顺序，奇数层的话就从头加node到list里，偶数层就从尾巴加

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(root, res, 0);
        return res;
    }
    
    public void levelHelper(TreeNode root, List<List<Integer>> res, int depth){
        //where recursion stop
        if(root==null)
            return;
        
        if(depth>=res.size())
            res.add(new ArrayList<Integer>());
        
        //用层的奇偶数来处理放入的顺序，奇数层的话就从头加node到list里，偶数层就从尾巴加
        if(depth%2==0)
            res.get(depth).add(root.val);
        else 
            res.get(depth).add(0, root.val);
        
        levelHelper(root.left, res, depth+1);
        levelHelper(root.right, res, depth+1);
    }
}