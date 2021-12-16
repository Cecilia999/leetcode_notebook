# 1740. Find Distance in a Binary Tree

## problem

Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
Output: 3
Explanation: There are 3 edges between 5 and 0: 5-3-1-0.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
Output: 2
Explanation: There are 2 edges between 5 and 7: 5-2-7.
Example 3:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
Output: 0
Explanation: The distance between a node and itself is 0.

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 10^9
All Node.val are unique.
p and q are values in the tree.

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

//思路：这道题其实相当于寻找common ancestor，
//然后把两个node到这个common ancestor的距离一加就是两个node之间的distance
//try to do this in one pass

class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        return findPath(lca, p, 0) + findPath(lca, q, 0);
    }

    public TreeNode findLCA(TreeNode root, int p, int q){
        if(root == null)
            return null;
        if(root.val == p || root.val==q)
            return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left!=null && right!=null)
            return root;
        else if(left!=null && right==null)
            return left;
        else if(left==null && right!=null)
            return right;
        else
            return null;
    }

    public int findPath(TreeNode root, int target, int level){
        if(root==null)
            return 0;
        if(root.val == target)
            return level;

        int left = findPath(root.left, target, level+1);
        int right = findPath(root.right, target, level+1);

        return left + right;
    }
}
```
