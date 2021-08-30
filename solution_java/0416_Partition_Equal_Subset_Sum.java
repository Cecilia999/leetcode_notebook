//思路：
//这一题是典型的完全背包的题型。在 n 个物品中选出一定物品，完全填满 sum/2 的背包。
//F(n,C) 代表将 n 个物品填满容量为 C 的背包，
//状态转移方程为 F(i,C) = F(i - 1,C) || F(i - 1, C - w[i])。
//当 i - 1 个物品就可以填满 C ，这种情况满足题意。同时如果 i - 1 个物品不能填满背包，加上第 i 个物品以后恰好可以填满这个背包，也可以满足题意。
//时间复杂度 O( n * sum/2 ) = O( n * sum)。

class Solution {
  public boolean canPartition(int[] nums) {
      int sum=0, n=nums.length;
      for(int i=0; i<n; i++){
          sum += nums[i];
      }
      
      if(sum%2!=0) return false;
      sum /= 2;
      
      //row: 0~nums[i]
      //col: 0~sum
      boolean[][] dp = new boolean[n+1][sum+1];     
      dp[0][0] = true;
      
      //对于nums=0, 任意大小的背包都不会被填满,java会default false,可省略
      for(int i=1; i<=sum; i++)
          dp[0][i] = false;
      
      //对于背包size=0，他本来就是满的
      for(int i=1; i<=n; i++)
          dp[i][0] = true;
      
      for(int i=1; i<=n; i++){
          for(int j=1; j<=sum; j++){
              
              //如果不装： dp[i][j] = dp[i-1][j]
              //如果装：  dp[i][j] = dp[i-1][j-nums[i-1]]
              dp[i][j] = dp[i-1][j];
              if(j>=nums[i-1]){
                  dp[i][j] = ( dp[i][j] || dp[i-1][j-nums[i-1]]);
              }
              
          }
      }
      return dp[n][sum];
  }
}

//优化到1d array
//1d-array的重点是：j要倒着遍历！！！！！！！！！！！！！！
// for(int j=sum; j>=num; j--){            
//     dp[j] = ( dp[j] || dp[j-num]);
// }

//dp[j]表示j size的背包能不能被装满

class Solution {
  public boolean canPartition(int[] nums) {
      int sum=0, n=nums.length;
      for(int i=0; i<n; i++){
          sum += nums[i];
      }
      
      if(sum%2!=0) return false;
      sum /= 2;
      
      boolean[] dp = new boolean[sum+1]; 
      Arrays.fill(dp, false);
      dp[0] = true;
      
      //只对每个nums中的num loop
      for( int num: nums){
          //j>=nums[i-1] 时间优化，不满足这个条件也不会更新dp
          for(int j=sum; j>=num; j--){ 
              //如果不装： dp[j] = dp[j] 即相当于2darray中的dp[i][j] = dp[i-1][j], 不update即即成之前的
              //如果装：  dp[j] = dp[j-num]
              dp[j] = ( dp[j] || dp[j-num]);
          }
      }
      return dp[sum];
  }
}