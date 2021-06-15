//这道题和jz65矩阵中的路径一模一样

class Solution {
  private int rows;
  private int cols;
  private boolean[][] visited;
  public boolean exist(char[][] board, String word) {
      rows = board.length;
      cols = board[0].length;
      visited = new boolean[rows][cols];
      
      for(int i=0; i<rows; i++){
          for(int j=0; j<cols; j++){
              if(board[i][j] == word.charAt(0)){
                  if(checkPath(i, j, board, word, 0))
                      return true;
              }            
          }
      }
      
      return false;
      
  }
  
  private boolean checkPath(int i, int j, char[][] board, String word, int cur){
      
      if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j]==true || board[i][j]!=word.charAt(cur))
          return false;
      if(cur==word.length()-1)
          return true;
      
      //backtrack
      visited[i][j] = true;
      boolean res = checkPath(i+1, j, board, word, cur+1) || 
          checkPath(i, j+1, board, word, cur+1) || 
          checkPath(i-1, j, board, word, cur+1) || 
          checkPath(i, j-1, board, word, cur+1);
      visited[i][j] = false;
      
      return res;
  }
}