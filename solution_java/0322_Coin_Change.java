//思路：
//之前的0/1背包是对可以放入背包的每个东西loop，每个东西只能放一次，不能重复，看是否能填满背包
//这道题是unbounded knackpack，即每个东西可以多次放，可以重复
//
//所以最外面的for loop不是loop item list而是loop背包的size
//对于每个size的背包，算有多少种填满背包的方式

//Return the fewest number of coins that you need to make up that amount. 
//所以应该选择min

class Solution {
  public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount+1];
      
      //bottom case
      //用来处理 If that amount of money cannot be made up by any combination of the coins, return -1
      dp[0] = 0;
      for(int i=1; i<=amount; i++){
          dp[i] = amount + 1;          //任意比amount大的数都行
      } 
      
      for(int i=1; i<=amount; i++){
          for (int coin : coins){
              if(coin<=i)
                  dp[i] = Math.min(dp[i], dp[i-coin]+1);
          }
      }
      
      if(dp[amount]>amount)
          return -1;
      
      return dp[amount];
  }
}