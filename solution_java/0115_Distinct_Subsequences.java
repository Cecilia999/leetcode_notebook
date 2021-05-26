//思路：DP
//这种两个string的问题都要想到dp
//dp[i][j] = s[1:i]包含t[1:j]的个数
//如果s[i+1] == t[j+1]，有 2 种匹配方式
//一种将 s[i+1] 与 t[j+1] 匹配，那么 s[1:i]匹配 t[1:j]的子序列，子序列数为 dp[i][j]；
//第二种将 s[i] 不与 t[j+1] 匹配，t[1:j+1] 作为 s[1:i] 的子序列，子序列数为 dp[i][j+1]
//比如 s=rabb t=rab 这个b可以与第一个b配对或者第二个b配对
//
// "r" & "r" 的expect output=1
class Solution {
  public int numDistinct(String s, String t) {
      int slen = s.length();
      int tlen = t.length();
      if(slen<tlen) return 0;
      
      int[][] dp = new int[slen+1][tlen+1];
      
      //dp[i][0] = 1 since empty string t is a subsequence
      //of every string(even empty string itself)
      for(int i=0; i<slen+1; i++){
          dp[i][0] = 1;
      }
      
      //dp[0][j] = 0 since no string is a subsequence of
      //empty string except for empty stirng.
      //0 不用initialize也是0
      for(int j=1; j<tlen+1; j++){
          dp[0][j] = 0;
      }
      
      for(int i=0; i<slen; i++){
          for(int j=0; j<tlen; j++){
              if(s.charAt(i)==t.charAt(j))
                  dp[i+1][j+1] = dp[i][j]+dp[i][j+1];
              else
                  dp[i+1][j+1] = dp[i][j+1];
          }
      }
      
      return dp[slen][tlen];
  }
}