//思路
//回溯/dp/递归
//对于每个index，如果
//1. 他在matrix的边界内，即 i，j在0～rows & 0～cols范围内
//2. i，j在threshold范围内
//3. 没有visited过
//则计算他往上下左右运动的范围

public class Solution {
  public int movingCount(int threshold, int rows, int cols) {
      int[][] visited = new int[rows][cols];
      return count(0, 0, rows, cols, threshold, visited);
  }
  
  private int count(int i, int j, int rows, int cols, int threshold, int[][] visited){
      if( i<0 || i>=rows || j<0 || j>=cols || indexSum(i, j)>threshold || visited[i][j]==1 ){
          return 0;
      }
      visited[i][j] = 1;
      return 1 + count(i+1, j, rows, cols, threshold, visited)
          + count(i, j+1, rows, cols, threshold, visited)
          + count(i-1, j, rows, cols, threshold, visited)
          + count(i, j-1, rows, cols, threshold, visited);
  }
  
  private int indexSum(int i, int j){
      int sum = 0;
      sum = i/10 + i%10 + j/10 + j%10;
      return sum;
  }
}