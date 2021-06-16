//这题是54题的加强版，用一样的逻辑就行
//因为题目限制是nxn matrix 所以不会有单列的edge case

class Solution {
  public int[][] generateMatrix(int n) {
      int[][] matrix = new int[n][n];
      
      int rowBegin = 0, colBegin = 0;
      int rowEnd = n-1, colEnd = n-1;
      int num = 1, size = 0;
      
      while(rowBegin<=rowEnd && colBegin<=colEnd){
          //traverse right
          for(int j=colBegin; j<=colEnd && size<n*n; j++){
              matrix[rowBegin][j] = num;
              num++;
              size++;
          }
          rowBegin++;
          
          //traverse down
          for(int i=rowBegin; i<=rowEnd && size<n*n; i++){
              matrix[i][colEnd] = num;
              num++;
              size++;
          }
          colEnd--;
          
          //traverse left
          for(int j=colEnd; j>=colBegin && size<n*n; j--){
              matrix[rowEnd][j] = num;
              num++;
              size++;
          }
          rowEnd--;
          
          //traverse up
          for(int i=rowEnd; i>=rowBegin && size<n*n; i--){
              matrix[i][colBegin] = num;
              num++;
              size++;
          }
          colBegin++;
      }
      
      return matrix;
  }
}