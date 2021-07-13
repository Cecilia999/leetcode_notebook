// 题目大意 #
// 后根遍历一颗树。

// 解题思路 #
// 用stack postorder traversal模版

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            list.add(0,curr.val);
            
            if(curr.left!=null)
                stack.push(curr.left);
            if(curr.right!=null)
                stack.push(curr.right);
        }
        
        return list;
    }
}

//法2
public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    
    while( root!=null || !stack.isEmpty()){
        while(root!=null){
            stack.push(root);
            list.add(0, root.val); //reverse the process of preorder
            root = root.right;
        }
        root = stack.pop();
        root = root.left;
    }
    
    return list;
}