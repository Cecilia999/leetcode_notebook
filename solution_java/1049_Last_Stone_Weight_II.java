//思路：
//这个问题就可以转化为 01 背包问题。从数组中找到 sum/2 重量的石头集合，如果一半能尽量达到 sum/2，那么另外一半和 sum/2 的差是最小的，最好的情况就是两堆石头的重量都是 sum/2，那么两两石头对碰以后最后都能消失。01 背包的经典模板可以参考第 416 题。
//dp[i] 代表size i的背包可以装的重量
//最后return sum-2*dp[sum/2]

class Solution {
  public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for(int stone : stones){
          sum += stone;
      }
      
      int[] dp = new int[sum/2 + 1];
      //不用initialize bottom case因为size0的背包什么都装不下dp[0]=0
      
      for(int stone : stones){
          for(int i=sum/2; i>=stone; i--){
              dp[i] = Math.max(dp[i], dp[i-stone]+stone);
          }
      }
      return sum-2*dp[sum/2];
  }
}