//思路：prices[i]>price[i-1]你就赚了，prices[i]<price[i-1]你就亏了
//这道题就是53题 max subarray,算出前天买今天卖的profit，求整个array最大的max subarray是多少
//求[7,1,5,3,6,4]的最大profit就相当于求[0，-6，4，-2，3，-2]的max subarray
//dp[i] = 0:i subarray的最大profit
//dp[i] = Math.max(dp[i-1], 0) + arr[i]
//这里arr[i]为前一天买今天卖的profit
//如果前面这些天的profit是亏的，就从今天开始买起，如果是赚的，就继续

// class Solution {
//     public int maxProfit(int[] prices) {
//         int[] dp = new int[prices.length];
//         int max = 0;
        
//         //initialize bottom case;
//         dp[0] = 0;
        
//         for(int i=1; i<prices.length; i++){
//             dp[i] = Math.max(dp[i-1], 0) + prices[i]-prices[i-1];
//             max = Math.max(dp[i], max);
//         }

//         return max;
//     }
// }

//dp不需要一个list来存，只需要存最后一个值就行，优化space

class Solution {
  public int maxProfit(int[] prices) {
      int dp = 0;
      int max = 0;        
      
      for(int i=1; i<prices.length; i++){
          dp = Math.max(dp, 0) + prices[i]-prices[i-1];
          max = Math.max(dp, max);
      }

      return max;
  }
}