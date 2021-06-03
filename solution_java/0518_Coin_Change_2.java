//思路：
//这就是个经典的unbounded knackpack问题：
//用a list of item有多少种填满size=amount背包的方式，可以重复选择同一个item

// The difference is that if you update dp while:

// increasing i then the previous partial result dp[i - coin] is the result that has considered coin already
// decreasing i then the previous partial result dp[i - coin] is the result that has not considered coin yet

// /** 
//  * @return number of ways to make sum s using repeated coins
//  */
// public static int coinrep(int[] coins, int s) {
//     int[] dp = new int[s + 1]; 
//     dp[0] = 1;          
//     for (int coin : coins)      
//         for (int i = coin; i <= s; i++)         
//             dp[i] += dp[i - coin];                                  
//     return dp[s];
// }                                       
                                            
// /**
//  * @return number of ways to make sum s using non-repeated coins
//  */
// public static int coinnonrep(int[] coins, int s) {
//     int[] dp = new int[s + 1];
//     dp[0] = 1;  
//     for (int coin : coins)
//         for (int i = s; i >= coin; i--)
//             dp[i] += dp[i - coin];              
//     return dp[s];                                                   
// } 

class Solution {
  public int change(int amount, int[] coins) {
      int[] dp = new int[amount+1];
      
      //!
      dp[0] = 1;
      //array default initilize = 0
      
      for(int coin : coins){
          for(int i=coin; i<=amount; i++){
              dp[i] += dp[i-coin];
          }
      }
      
      return dp[amount];
  }
}