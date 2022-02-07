// 题目大意
// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

// 示例 1：
// 输入：nums = [1,5,11,5]
// 输出：true
// 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
// 示例 2：
// 输入：nums = [1,2,3,5]
// 输出：false
// 解释：数组不能分割成两个元素和相等的子集。

// 提示：
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

//思路：
//这一题是典型的完全背包的题型。在 n 个物品中选出一定物品，完全填满 sum/2 的背包。
//F(n,C) 代表将 n 个物品填满容量为 C 的背包，
//状态转移方程为 F(i,C) = F(i - 1,C) || F(i - 1, C - w[i])。
//当 i - 1 个物品就可以填满 C ，这种情况满足题意。同时如果 i - 1 个物品不能填满背包，加上第 i 个物品以后恰好可以填满这个背包，也可以满足题意。
//时间复杂度 O( n * sum/2 ) = O( n * sum)。

//这道题和coin change不同的是，一件物品只能放一次，不能重复选择
//所以先for each item， 再for knapsack size

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0)
            return false;
        sum /= 2;

        // row: 0~nums[i]
        // col: 0~sum
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        // 对于nums=0, 任意大小的背包都不会被填满,java会default false,可省略
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        // 对于背包size=0，他本来就是满的
        for (int i = 1; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                // 如果不装： dp[i][j] = dp[i-1][j]
                // 如果装： dp[i][j] = dp[i-1][j-nums[i-1]]
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }

            }
        }
        return dp[n][sum];
    }
}

// 优化到1d array
// 1d-array的重点是：j要倒着遍历！！！！！！！！！！！！！！
// for(int i=sum; i>=num; i--){
// dp[i] = ( dp[i] || dp[i-num]);
// }

// dp[i]表示i size的背包能不能被装满

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        // 如果sum不能被正好分成两份
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        // 这道题和coin change不同的是，一件物品只能放一次，不能重复选择
        // 所以先for each item， 再for knapsack size
        for (int num : nums) {
            // 对于每个背包size，判断能否被填满
            // 要从大到小计算，因为如果是从小到大的话dp[i-num]会被覆盖
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }
}