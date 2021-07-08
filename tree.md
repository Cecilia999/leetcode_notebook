# Tree

### recursion 递归

- [100. Same Tree](https://leetcode.com/problems/same-tree/):  
  [java](/solution_java/0100_Same_Tree.java)
- [572. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/):  
  [java](/solution_java/0572_Subtree_of_Another_Tree.java)

  递归遍历来计算一个 binary tree 的层数

- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/):
  [java](/solution_java/0104_Maximum_Depth_of_Binary_Tree.java)

## inorder travaersal (中根遍历)

主要的思路就是 maintain pre node, 比较 pre.val 和 root.val

### 1. iterative 模版 using stack

逻辑是先 iterative 到 left subtree 中最左的那个 node，然后由 left->root->right inorder 的顺序对 BST 进行遍历

    ```java
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

### 2. recursion

- [99. Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/):
  [java](/solution_java/0099_Recover_Binary_Search_Tree.java)

## level traversal 层层遍历

思路是用 depth 来 manage 当前的层数

- [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/):
  [java](/solution_java/0102_Binary_Tree_Level_Order_Traversal.java)
- [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/):
  [java](/solution_java/0103_Binary_Tree_Zigzag_Level_Order_Traversal.java)

计算二叉树层数看 [104 题](/solution_java/0104_Maximum_Depth_of_Binary_Tree.java)

## 给出 preorder/inorder/postorder 中的两种，construct binary tree 构造二叉树

- [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/):
  [java](/solution_java/0105_Construct_Binary_Tree_from_and_Inorder_Traversal.java)
- [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | [java](/solution_java/0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal.java)
