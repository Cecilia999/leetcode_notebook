// 题目大意 #
// 先根遍历一颗树。

// 解题思路 #
// 用stack preorder traversal模版

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            list.add(curr.val);
            
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
        }
        
        return list;
    }
}

//法2
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while( root!=null || !stack.isEmpty()){
            while(root!=null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            
            root=stack.pop();
            root=root.right;
        }
        
        return list;
    }
}