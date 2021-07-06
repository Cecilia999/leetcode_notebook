// 题目描述
// 根据一棵树的前序遍历与中序遍历构造二叉树。
// 你可以假设树中没有重复的元素。

// 例如，给出
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：
//     3
//    / \
//   9  20
//     /  \
//    15   7

// 解题思路
// 先序遍历的顺序：根节点，左子树，右子树；中序遍历的顺序：左子树，根节点，右子树。
// preorder的pre[0]就是第一个root，我们在inorder中找到这个root所在的位置，前面的部分是左子树，后面的部分是右子树
//            root  left  right
// preorder = [3,   9,    20,15,7]
//           left   root  right
// inorder = [9,    3,    15,20,7]

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Tree(0, 0, inorder.length-1, preorder, inorder);
    }
    
    public TreeNode Tree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        //where recursion stop
        if(preStart > preorder.length-1 || inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //find index of current root in inorder
        int index = inStart;
        while(inorder[index]!=root.val && index<=inEnd){
            index++;
        }
        
        
        root.left = Tree(preStart+1, inStart, index-1, preorder, inorder);
        root.right = Tree(preStart+(index-inStart+1), index+1, inEnd, preorder, inorder);
        
        return root;
    }
}