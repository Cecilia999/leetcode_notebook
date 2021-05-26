//思路：DP但是题目限制了space complexity O(n)，只能用一维的dp，所以用长度为triangle最后一行的array且不断的更新它

//bottom up dp = the minimum path sum from top to bottom.
//先用二维的dp想的话
//从第二行开始 dp[i][j] = Math.min(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j])
//由于限制了空间复杂度，所以用一维的dp array代替，
//对于triangle[i][j], dp[j] = Math.min(dp[j+1], dp[j]) + triangle[i][j]

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      int triSize = triangle.size();
      //因为是triangle所以rolsize==colsize
      int[] dp = new int[triSize];
      
      //先给最后一行赋值
      for(int j=0; j<triangle.get(triSize-1).size(); j++){ 
           dp[j] = triangle.get(triSize-1).get(j);          
      }

      for(int i=triSize-2; i>=0; i--){
          for(int j=0; j<triangle.get(i).size(); j++){                     
              dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
          }
      }
      
      return dp[0];
  }
}

