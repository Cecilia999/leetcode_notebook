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
    
    n = 0;     null   
    
    count[0] = 1
    
    
    n = 1;      1       
    
    count[1] = 1 
    
    
    n = 2;    1__       			 __2     
    		      \					/                 
    		     count[1]	   	count[1]	
    
    count[2] = 1 + 1 = 2
    
    
    
    n = 3;    1__				      __2__	                   __3
    		      \		            /       \			      /		
    		  count[2]		  count[1]    count[1]		count[2]
    
    count[3] = 2 + 1 + 2  = 5
    
    
    
    n = 4;    1__  					__2__					   ___3___                  
    		      \				 /        \					  /		  \			
    		  count[3]		 count[1]    count[2]		  count[2]   count[1]
    
                 __4				
               /
           count[3]   
    
    count[4] = 5 + 2 + 2 + 5 = 14     
    

And  so on...
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