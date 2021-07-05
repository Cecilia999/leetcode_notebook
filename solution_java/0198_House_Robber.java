// 题目大意 #
// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

// 解题思路 #
// 你是一个专业的小偷，打算洗劫一条街的所有房子。每个房子里面有不同价值的宝物，但是如果你选择偷窃连续的 2 栋房子，就会触发警报系统，编程求出你最多可以偷窃价值多少的宝物？
// 这一题可以用 DP 来解答，也可以用找规律的方法来解答。
// DP 的状态定义是：dp[i] 代表抢 nums[0,i] 这个区间内房子的最大值，
//状态转移方程是 dp[i] = max(dp[i-1], nums[i]+dp[i-2]) 。
//可以优化迭代的过程，用两个临时变量来存储中间结果，以节约辅助空间。


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);        //dp[1]!=nums[1]!!
        
        
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        return Math.max(dp[n-1], dp[n-2]);
    }
}