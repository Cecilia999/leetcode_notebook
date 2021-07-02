// 题目大意 #
// 给定一个无序的整数数组，找到其中最长上升子序列的长度。

// 解题思路 #
// 给定一个整数序列，求其中的最长上升子序列的长度。这一题就是经典的 LIS 最长上升子序列的问题。
// dp[i] 代表为第 i 个数字为结尾的最长上升子序列的长度。换种表述，dp[i] 代表 [0,i] 范围内，选择数字 nums[i] 可以获得的最长上升子序列的长度。
// 状态转移方程为 dp[i] = max( 1 + dp[j]) ，
// 其中 j < i && nums[j] > nums[i]，取所有满足条件的最大值。时间复杂度 O(n^2)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] =  Math.max(1+dp[j], dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        
        return max;
    }
}