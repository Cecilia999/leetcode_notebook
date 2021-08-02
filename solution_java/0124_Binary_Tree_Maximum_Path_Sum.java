// 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
// 该路径 至少包含一个 节点，且不一定经过根节点。
// 路径和 是路径中各节点值的总和。
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。

// 输入：root = [1,2,3]
// 输出：6
// 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6

// 输入：root = [-10,9,20,null,null,15,7]
// 输出：42
// 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

// 解题思路

// - 路径每到一个节点，有 3 种选择：1. 停在当前节点。2. 走到左子节点。3. 走到右子节点。
// - 走到子节点，又面临这 3 种选择，递归就是用来处理这种规模不一样的相同问题。
// - 注意，不能走进一个分支又掉头回来走另一个分支，路径会重叠，不符合定义。

// 定义递归函数
// 对于某个节点，它关心自己走入一个子树，能从中捞取的最大收益，先不用管具体怎么走。
// 定义dfs函数：返回当前子树能向父节点“提供”的最大路径和。
// 即，一条从父节点延伸下来的路径，能在当前子树中获得的最大收益。分为三种情况：

// - 路径停在当前子树的根节点，在这个子树中收益：root.val
// - 走入左子树，在这个子树中的最大收益：root.val + dfs(root.left)
// - 走入右子树，在这个子树中的最大收益：root.val + dfs(root.right)
// 对应了前面所讲的三种选择，最大收益取三者最大：root.val + max(dfs(root.left), dfs(root.right))

// 再次提醒: 一条从父节点延伸下来的路径，不能走入左子树又掉头走右子树，不能两头收益，路径会重叠。
// 当遍历到null节点时，null 子树提供不了收益，返回 0。
// 如果某个子树 dfs 结果为负，走入它，收益不增反减，该子树应被忽略，杜绝选择走入它的可能，让它返回 0，像null一样，如同砍掉。

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
    private int max = Integer.MIN_VALUE;  //最大路径
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root){
        if(root==null)  // 遍历到null节点，收益0
            return 0;
        
        int left = dfs(root.left);  // 左子树可以提供的最大路径
        int right = dfs(root.right);  // 右子树可以提供的最大路径
        
        int currPathSum = root.val + left + right;  //当前子树内部的最大路径和
        max = Math.max(max, currPathSum);  // 挑战最大纪录
        
        int outputPathSum = root.val + Math.max(left, right);  // 当前子树对外提供的最大和
        // 对外提供的路径和为负，直接返回0。否则正常返回
        return outputPathSum>0? outputPathSum:0;
    }
}