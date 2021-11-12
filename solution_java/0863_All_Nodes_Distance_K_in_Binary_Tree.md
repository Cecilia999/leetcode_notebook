# 863. All Nodes Distance K in Binary Tree

## 题目大意

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

## 解题思路

1. recursively search target, record the distance along the path to the target
2. dfs the tree, if distance is == k, add to the res list

## code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        //<curNode, curNode distance from target>
        HashMap<TreeNode, Integer> map = new HashMap<>();
        recordDistance(root, target, map);
        dfs(root, map, res, k, map.get(root));
        return res;
    }

    public int recordDistance(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> map){
        if(root==null) return -1;
        if(root==target) {
            map.put(root, 0);
            return 0;
        }

        int left = recordDistance(root.left, target, map);
        if(left>=0){
            map.put(root, left+1);
            return left+1;
        }

        int right = recordDistance(root.right, target, map);
        if(right>=0){
            map.put(root, right+1);
            return right+1;
        }

        //if not find anything in this path, return -1
        return -1;
    }

    public void dfs(TreeNode root, HashMap<TreeNode, Integer> map, List<Integer> res, int k, int distance){
        if(root==null) return;
        if(map.containsKey(root)) distance = map.get(root);
        if(distance==k)
            res.add(root.val);
        dfs(root.left, map, res, k, distance + 1);
        dfs(root.right, map, res, k, distance + 1);
    }
}
```
