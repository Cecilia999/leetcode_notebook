class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;

        for(int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            dp[i][2] = dp[i-1][1]+prices[i];
        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);
    }
}

//只需要记录昨天的值，优化空间复杂度为O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;

        for(int i=1; i<prices.length; i++){
            dp[i%2][0] = Math.max(dp[(i-1)%2][0], dp[(i-1)%2][2]);
            dp[i%2][1] = Math.max(dp[(i-1)%2][1], dp[(i-1)%2][0]-prices[i]);
            dp[i%2][2] = dp[(i-1)%2][1]+prices[i];
        }

        return Math.max(dp[(prices.length-1)%2][0], dp[(prices.length-1)%2][2]);
    }
}