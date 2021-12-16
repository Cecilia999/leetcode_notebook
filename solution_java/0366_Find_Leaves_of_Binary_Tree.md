# 366. Find Leaves of Binary Tree

## problem

Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.

Example 1:

Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
Example 2:

Input: root = [1]
Output: [[1]]

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

## solution

1. 这道题实际上就是算每个 node 的 height
2. dfs + recursion

## code

```java
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(res, root);
        return res;
    }

    public int height(List<List<Integer>> res, TreeNode cur){
        if(cur==null){
            return -1;
        }

        //注意！height是subnode的max height + 1
        int level = 1 + Math.max(height(res, cur.left), height(res, cur.right));

        //注意！必须要先allocate memory space
        if(res.size()<level+1)
            res.add(new ArrayList<>());
        res.get(level).add(cur.val);
        return level;
    }
}
```
