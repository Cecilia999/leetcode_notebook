# Tree

## 1. recursion 递归

- [100. Same Tree](https://leetcode.com/problems/same-tree/):  
  [java](/solution_java/0100_Same_Tree.java)
- [572. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/):  
  [java](/solution_java/0572_Subtree_of_Another_Tree.java)

## 2. inorder iterative 模版 using stack

逻辑是先 iterative 到 left subtree 中最左的那个 node，然后由 left->root->right inorder 的顺序对 BST 进行遍历

    ```
    public <T> isValidBST(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();

    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        /*

            一些判断条件

        */
        pre = root;
        root = root.right;
    }
    return ;
    }
    ```

- [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/):
  [java](/solution_java/0098_Validate_Binary_Search_Tree.java)
- [230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/):
  [java](/solution_java/0230_Kth_Smallest_Element_in_a_BST.java)
- [98. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/):
  [java](/solution_java/0094_Binary_Tree_Inorder_Traversal.java)
