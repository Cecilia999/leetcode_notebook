// 题目大意 #
// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
// 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
// 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

// 解题思路 #
// 这一题是第 198 题的加强版。不过这次是在一个环形的街道中，即最后一个元素和第一个元素是邻居，
// 在不触碰警报的情况下，问能够窃取的财产的最大值是多少？
// 解题思路和第 198 完全一致，只需要增加额外的一个转换。由于首尾是相邻的，
// 所以在取了第一个房子以后就不能取第 n 个房子，那么就在 [0,n - 1] 的区间内找出总价值最多的解，
// 然后再 [1,n] 的区间内找出总价值最多的解，两者取最大值即可。

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        
        int max = Math.max(rob213(nums, 0, n-2), rob213(nums, 1, n-1));
        return max;
    }
    
    public int rob213(int[] nums, int start, int end){
        //边界很容易错！！！
        int[] dp = new int[end+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(dp[start], nums[start+1]);

        //i从start+2 ～ =end
        for(int i=start+2; i<=end; i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        
        return dp[end];
    }
}