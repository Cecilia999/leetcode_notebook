class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      boolean[] dp = new boolean[s.length()+1];
      
      dp[0] = true;
      
      //用左右指针l&r
      for(int r=1; r<=s.length(); r++){
          for(int l=0; l<r; l++){
              
              //dp[l] == true:
              //means s.substring(0,l) is contained in the wordDict
              
              //e.g. i=5, j=3 for s=leetcode wordDict = ["leet","code"]
              //dp[3] = true since leet is in wordDict
              //dp[5] = false since s.substring(3, 5) -> "co" is not in wordDict
              if(dp[l] && wordDict.contains(s.substring(l,r)))
                  dp[r] = true;
          }
      }
      
      return dp[s.length()];
  }
}