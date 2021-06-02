//思路：
//是个经典的2d背包问题
//给定一个字符串数组和 m，n，其中所有的字符都是由 0 和 1 组成的。问能否从数组中取出最多的字符串，使得这些取出的字符串中所有的 0 的个数 ≤ m，1 的个数 ≤ n。

//这一题是典型的 01 背包的题型。只不过是一个二维的背包问题。在 n 个物品中选出一定物品，尽量完全填满 m 维和 n 维的背包。为什么是尽量填满？因为不一定能完全填满背包。

//dp[i][j] 代表尽量填满容量为 (i,j) 的背包装下的物品总数
//状态转移方程为 dp[i][j] = max(dp[i][j], 1+dp[i-zero][j-one])。
//其中 zero 代表的当前装入物品在 m 维上的体积，也即 0 的个数。one 代表的是当前装入物品在 n 维上的体积，也即 1 的个数。
//每添加一个物品，比较当前 (i,j) 的背包装下的物品总数和 (i-zero,j-one) 的背包装下的物品总数 + 1，比较这两者的大小，保存两者的最大值。
//每添加一个物品就刷新这个二维背包，直到所有物品都扫完一遍。dp[m][n] 中存储的就是最终的答案。时间复杂度 O( n * M * N )。

class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
      int[][] dp = new int[m+1][n+1];
      int len = strs.length;

      //bottom case: initialize the 2d array to 0
      for(int i=0; i<=m; i++){
          Arrays.fill(dp[i], 0);
      }
      
      for(int index=0; index<len; index++){
          int zero=0, one=0;
          for(char c : strs[index].toCharArray()){
              if(c=='0')  zero+=1;
              else if(c=='1') one+=1;
                  
          }
          
          for(int i=m; i>=zero; i--){
              for(int j=n; j>=one; j--){
                  dp[i][j]=Math.max(dp[i][j], dp[i-zero][j-one]+1);
              }
          }
      }
      
      return dp[m][n];
      
  }
}