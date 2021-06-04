//思路：
//小技巧：用2d array表示方向：
//  int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

//递归，记忆化搜索
class Solution {
  public static final int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  
  public int longestIncreasingPath(int[][] matrix) {
      int row = matrix.length, col = matrix[0].length;
      
      int[][] dp = new int[row][col];
      int max = 1;
      
      for(int i=0; i<row; i++){
          for(int j=0; j<col; j++){
              max = Math.max(findLongest(dp, i, j, matrix), max);
          }
      }
      
      return max;
  }
  
  private int findLongest(int[][] dp, int i, int j, int[][] matrix){
      //已经搜索过了直接return！
      if(dp[i][j]!=0) return dp[i][j];
      
      int curMax = 1;
      for(int[] move : moves){
          int row=i+move[0], col = j+move[1];
          
          if(row<0 || row>=matrix.length || col<0 || col>=matrix[0].length || matrix[row][col]<=matrix[i][j])
              continue;
          //如果i，j向上下左右可以走，curMax表示上下左右可以走得最远的一条有多远
          curMax = Math.max(curMax, findLongest(dp, row, col, matrix));
          dp[i][j]=1 + curMax; 
      }
      
      return dp[i][j];
  }
}