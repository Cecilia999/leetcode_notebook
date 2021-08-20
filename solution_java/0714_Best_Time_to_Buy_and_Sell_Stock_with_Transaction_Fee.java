class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee;
        
        for(int i=1; i<prices.length; i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]-fee);
            //transaction fee只有买入的时候才要
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        }
        
        return dp[prices.length-1][0];
    }
}

//因为只需要昨天的值，优化空间成O(1)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][2];
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee;
        
        for(int i=1; i<prices.length; i++){
            dp[i%2][1] = Math.max(dp[(i-1)%2][1], dp[(i-1)%2][0] - prices[i]-fee);
            //transaction fee只有买入的时候才要
            dp[i%2][0] = Math.max(dp[(i-1)%2][0], dp[(i-1)%2][1] + prices[i]);
        }
        
        return dp[(prices.length-1)%2][0];
    }
}