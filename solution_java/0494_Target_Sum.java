// 题目大意
// 给你一个整数数组 nums 和一个整数 target 。
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

// 示例 1：
// 输入：nums = [1,1,1,1,1], target = 3
// 输出：5
// 解释：一共有 5 种方法让最终目标和为 3 。
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

// 示例 2：
// 输入：nums = [1], target = 1
// 输出：1
//  
// 提示：
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000

//方法一
//解题思路：用数学关系转化成416题
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

//方法2 不使用数学转换的正常dp逻辑解法
class Solution {
    //和最大不会超过1000
    private static final int OFFSET = 1000;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, t=2*OFFSET+1;

        //dp[i][j]定义为从数组nums中 0 - i 的元素进行加减可以得到 j 的方法数量
        int[][] dp = new int[n][t];
        dp[0][OFFSET + nums[0]] += 1;
        dp[0][OFFSET - nums[0]] += 1;

        //状态转移方程
        //不是选不选nums[i]放入背包而是决定nums[i]是加还是减
        //dp[i][j] = dp[i - 1][j-nums[i]] + dp[i - 1][j+nums[i]]
        //dp[i][j]的结果值就是加/减之后对应位置的和。

        for(int i=1; i<n; i++){
            for(int j=0; j<t; j++){
                //边界
                //如果减去nums[i], j应该>=0
                //如果加上nums[i]， j应该<offset
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }

        return dp[n-1][OFFSET+target];
    }
}