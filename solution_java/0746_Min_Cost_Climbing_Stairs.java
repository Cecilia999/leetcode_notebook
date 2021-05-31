//思路：
//升级版的fibonacci number with cost[i] for each stair
//dp[i]是上到第n层的最少花飞
//dp[i] = cost[i] + min(dp[i-1], dp[i-2])
//重点！！！！！！要处理最后return
//应该return min (dp[n-1], dp[n-2])!!!!!
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        
        //可以优化只用int[] dp = new int[2]来保留前面的dp[i-1], dp[i-2]
        //(但好像优化的memory space不是很多)
        int[] dp = new int[n];
        
        dp[0]=cost[0];
        dp[1]=cost[1];
        
        for(int i=2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        
        return Math.min(dp[n-1], dp[n-2]);
    }
}