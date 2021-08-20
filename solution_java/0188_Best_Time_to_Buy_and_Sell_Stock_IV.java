class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[k+1][2];
        
        //注意，每次交易至少需要2天
        //当 k >= （len/2）时，这道题转化为 122题:多次买卖，可以任意买卖
        //可以加进来，也可以直接使用dp, 加进来runtime会更慢，因为需要判断
        // if (k == 0 || len < 2) 
        //     return 0;
        // if(k>= len/2)
        //     return greedy(prices);
        
        //初始化 下标为0 天的交易状态
        for(int j=0; j<=k; j++){
            dp[j][1] = Integer.MIN_VALUE;
        }
        
        for(int price : prices){
            for(int j=1; j<=k; j++){
                //前一天手持股票，正在交易第j次，今天休息
                //前一天已经交易j-1次，今天买入
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0]-price);
                
                //前一天手持现金，已经交易第j次，今天休息
                //前一天手持股票，正在交易第j次，今天卖出
                dp[j][0] = Math.max(dp[j][0], dp[j][1]+price);
            }
        }
       
        return dp[k][0];
    }
    
    // private int greedy(int[] prices){
    //     int res=0;
    //     for(int i=1; i<prices.length; i++){
    //         if((prices[i] - prices[i-1]) > 0)
    //             res += prices[i] - prices[i-1];
    //     }
    //     return res;
    // }
}