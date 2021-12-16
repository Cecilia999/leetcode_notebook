# 314. Binary Tree Vertical Order Traversal

## problem

Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:

Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:

Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]
Example 4:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

## solution

1. 用 cols 来记录，当前的 node 是在那一行
   - 为了得到每一个 node 的 col，一定是要先遍历一遍整个 tree 的
   - node.left 为 col-1
   - node.right 为 col+1
2. bfs + queue
3. 把 col 对应的 list of node 存在 hashmap

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)  return res;
        //col, TreeNode.val
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colsQueue = new LinkedList<>();

        nodeQueue.offer(root);
        colsQueue.offer(0);

        int min=0, max=0;

        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int col = colsQueue.poll();

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if(node.left!=null){
                nodeQueue.offer(node.left);
                colsQueue.offer(col-1);
                min = Math.min(min, col-1);
            }
            if(node.right!=null){
                nodeQueue.offer(node.right);
                colsQueue.offer(col+1);

                max = Math.max(max, col+1);
            }
        }

        for(int i=min; i<=max; i++){
            res.add(map.get(i));
        }

        return res;
    }
}
```
