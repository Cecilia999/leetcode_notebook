// 题目大意 #
// 判断一棵树是不是平衡二叉树。平衡二叉树的定义是：树中每个节点都满足左右两个子树的高度差 <= 1 的这个条件。

//bottom-up
//dfs先递归到root==null
//然后一层层往上+height
//check leftheight vs rightheight
//O(N)

class Solution {
    public boolean isBalanced(TreeNode root) {
        int res = checkHeight(root);
        return res!=-1;
    }
    
    public int checkHeight(TreeNode root){
        if(root==null) return 0;
        
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) return -1;
        
        if(Math.abs(leftHeight-rightHeight)>1) 
            return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

//top-down 
//checks whether the tree is balanced strictly according to the definition of balanced binary tree: 
//the difference between the heights of the two sub trees are not bigger than 1, and both the left sub tree and right sub tree are also balanced. 
//可以利用104题计算depth
//O(N^2)

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	leftHight := depth(root.Left)
	rightHight := depth(root.Right)
	return abs(leftHight-rightHight) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func depth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return max(depth(root.Left), depth(root.Right)) + 1
}
