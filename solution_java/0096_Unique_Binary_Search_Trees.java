//思路：
//dp(n): the number of unique BST for a sequence of length n.
//F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.代表以 i 为根节点，1-n 个数组成的二叉排序树的不同的个数
//
//bottom case: dp(0)=1, dp(1)=1
//dp(n) = F(1, n) + F(2, n) + ... + F(n, n). 
//
//对于任意F(i, n)我们可以得到他等于dp(i-1)和dp(n-i)的cartesian product（笛卡尔积）
//F(i, n) = dp(i-1)       *  dp(n-i)	         1 <= i <= n 
//          left sub-tree    right sub-tree

//dp(n) = dp(0) * dp(n-1) + dp(1) * dp(n-2) + … + dp(n-1) * dp(0) 

/*    
Hope it will help you to understand :

1,2,3, ..., n

            k
        /       \
   1 ~ (k-1)    (k+1) ~ n
    
   F(k, n) = 一共有 (k-1) x (n - k) 种 bst
*/

class Solution {
  public int numTrees(int n) {
      int[] dp = new int[n+1];
      dp[0]=dp[1]=1;
      
      for(int i=2; i<n+1; i++){
          for(int j=1; j<=i; j++){
              dp[i] += dp[j-1]*dp[i-j];
          }
      }
      
      return dp[n];
  }
}