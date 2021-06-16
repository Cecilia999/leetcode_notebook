//思路：按照题目的意思一圈一圈的loop
//use rowBegin, rowEnd, colBegin, colEnd to manage loop
//exit loop condition: when rowBegin meets rowEnd && colBegin meets colEnd

//edge case: matrix只有一个或者一行
//用res.size()<matrix size来manage edge case

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> list = new ArrayList<Integer>();
      
      //题目限制了matrix至少是1x1
      int m = matrix.length, n = matrix[0].length;
      int rowBegin=0, colBegin=0;
      int rowEnd = m-1;
      int colEnd = n-1;
      
      while(rowBegin<=rowEnd && colBegin<=colEnd){
          //traverse right
          for(int j=colBegin; j<=colEnd && list.size()<m*n; j++){
              list.add(matrix[rowBegin][j]);
          }
          rowBegin++;
          
          //traverse down
          for(int i=rowBegin; i<=rowEnd && list.size()<m*n; i++){
              list.add(matrix[i][colEnd]);
          }
          colEnd--;
          
          //traverse left
          for(int j=colEnd; j>=colBegin && list.size()<m*n; j--){
              list.add(matrix[rowEnd][j]);
          }
          rowEnd--;
          
          //traverse up
          for(int i=rowEnd; i>=rowBegin && list.size()<m*n; i--){
              list.add(matrix[i][colBegin]);
          }
          colBegin++;
      }
      
      return list;
  }
}