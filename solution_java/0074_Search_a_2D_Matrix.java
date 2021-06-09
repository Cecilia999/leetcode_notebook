//思路：把2d array当作 1d来计算位置
// m * n matrix convert to an array => matrix[x][y] => arr[x * n + y]
// an array convert to m * n matrix => arr[x] =>matrix[x / n][x % n];

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      //m x n matrix.
      int m = matrix.length, n = matrix[0].length;
      int low=0, high= m * n - 1;
      
      while(low<=high){
          int mid = low + (high-low)/2;
          
          if(matrix[mid/n][mid%n]==target)
              return true;
          else if(matrix[mid/n][mid%n]>target)
              high = mid-1;
          else 
              low = mid+1;
      }
      return false;
  }
}