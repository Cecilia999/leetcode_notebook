// 题目描述
// 根据一棵树的后序遍历与中序遍历构造二叉树。
// 你可以假设树中没有重复的元素。

//// 解题思路
//这题和105一样，只不过变成后序遍历
// 后序遍历的顺序：左子树，右子树，根节点；中序遍历的顺序：左子树，根节点，右子树。
// preorder的pre[length-1]就是第一个root，我们在inorder中找到这个root所在的位置，前面的部分是左子树，后面的部分是右子树
//            left   right      root
// preorder = [9,    15,7,20,   3]
//           root    root  right
// inorder = [9,     3,    15,20,7]

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return Tree(postorder.length-1, 0, inorder.length-1, postorder, inorder);
    }
    
    public TreeNode Tree(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder){
        //where to stop recursion
        if(postEnd<0 || inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        //find index of root in inorder 
        int index = inStart;
        while(inorder[index]!=postorder[postEnd] && inStart<=inEnd){
            index++;
        }
        
        root.left = Tree(postEnd-(inEnd-index+1), inStart, index-1, postorder, inorder);
        root.right = Tree(postEnd-1, index+1, inEnd, postorder, inorder);
        
        return root;
    }
}