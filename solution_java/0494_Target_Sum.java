//思路：用数学关系转化成416题
//题目要求在数组元素前加上 + 或者 - 号，其实相当于把数组分成了 2 组，一组全部都加 + 号，一组都加 - 号。记 + 号的一组 P ，记 - 号的一组 N，那么可以推出以下的关系:
//  sum(P) - sum(N) = target
//  sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                         2 * sum(P) = target + sum(nums)
//
//  这道题就转换成了，能否在数组中找到这样一个集合，和等于 (target + sum(nums)) / 2。
//  那么这题就转化为了第 416 题了。dp[i] 中存储的是能使和为 i 的方法个数。

class Solution {
  public int findTargetSumWays(int[] nums, int target) {
      int sum = 0, n=nums.length;
      for(int num : nums){
          sum += num;
      }
      
      if((target + sum)%2 != 0) return 0;
      int newSum = (target + sum)/2;
      
      int[] dp = new int[newSum+1];
      dp[0] = 1;        //bottom case initialize to 1
      
      for(int num : nums){
          for(int i=newSum; i>=num; i--){
              //换成2d就是 dp[i][j] = dp[i-1][j] + dp[i][j-nums[i]], 
              //i.e. you can get the sum j either by just repeating all the ways to get sum j by using first i-1 elements, or add nums[i] on top of each way to get sum j-nums[i] using first i elements
              dp[i] += dp[i-num];
          }
      }
      
      return dp[newSum];
  }
}