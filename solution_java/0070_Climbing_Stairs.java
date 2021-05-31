//思路：
//一个楼梯可以由 n-1 和 n-2 的楼梯爬上来。
//fibonacci number
class Solution {
  public int climbStairs(int n) {
      int[] dp = new int[n+1];
      dp[0]=dp[1]=1;
      
      for(int i=2; i<=n; i++){
          dp[i]=dp[i-1]+dp[i-2];
      }
      
      return dp[n];
  }
}