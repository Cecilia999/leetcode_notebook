class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[2][3][2];
        
        //确定初始值
        dp[0][0][0] = 0;
        // dp[0][0][1] 不存在
        
        dp[0][1][0] = 0; //不可能
        dp[0][1][1] = -prices[0];
        
        dp[0][2][0] = 0; //不可能
        dp[0][2][1] = Integer.MIN_VALUE; //不可能但是对比会用上
        
        for(int i=1; i<prices.length; i++){
            dp[i%2][1][1] = Math.max(dp[(i-1)%2][1][1], -prices[i]);
            dp[i%2][1][0] = Math.max(dp[(i-1)%2][1][0], dp[(i-1)%2][1][1] + prices[i]);
            
            dp[i%2][2][1] = Math.max(dp[(i-1)%2][2][1], dp[(i-1)%2][1][0] - prices[i]);
            dp[i%2][2][0] = Math.max(dp[(i-1)%2][2][0], dp[(i-1)%2][2][1] + prices[i]);
        }
        
        return Math.max(dp[(prices.length-1)%2][1][0], dp[(prices.length-1)%2][2][0]);
    }
}

//由于今天只参考了昨天的状态，所以直接去掉第一维不会影响状态转移的正确性

public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[3][2];
        dp[1][1] = -prices[0];
        dp[2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            dp[1][1] = Math.max(dp[1][1], -prices[i]);
            dp[1][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);
            dp[2][1] = Math.max(dp[2][1], dp[1][0] - prices[i]);
            dp[2][0] = Math.max(dp[2][0], dp[2][1] + prices[i]);
        }
        return Math.max(dp[1][0], dp[2][0]);
    }
}
