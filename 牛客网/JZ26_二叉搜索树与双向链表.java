//题目大意
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。

//解题思路
//将二叉树排序，即想到用inorder traversal
//不能create treenode 得到双向的链表：
//cur=指向当前node，pre指向当前node的前一个node
//按照顺序 1 <=> 2 <=> 3
//cur.left = pre   (cur.right = 下一个节点)
//pre.right = cur
//pre = cur

public class Solution {
    public TreeNode Convert(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        //用boolean head来处理return的双向链表的头
        boolean head = true;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            
            //将第一个节点记为root，用于return
            if(head){
                root = cur;
                pre = cur;
                head = false;
            }else{
                cur.left = pre;
                pre.right = cur;
                pre = cur;
            }
            cur = cur.right;
        }
        return root;
    }
}