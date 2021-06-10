//题目要求输出数组中某个区间内数字之和最大的那个值。
//dp[i] 表示 [0,i] 区间内各个子区间和的最大值，
//状态转移方程是 dp[i] = nums[i] + dp[i-1] (dp[i-1] > 0)，dp[i] = nums[i] (dp[i-1] ≤ 0)。

public class Solution {
  public int FindGreatestSumOfSubArray(int[] nums) {
      int[] dp = new int[nums.length+1];
      dp[0]=0;
      int max = nums[0];
      
      for(int i=1; i<=nums.length; i++){
          dp[i]=dp[i-1]>=0? dp[i-1]+nums[i-1]: nums[i-1];  
          max = Math.max(dp[i],max);
      }
       return Math.max(dp[nums.length], max);
  }
}