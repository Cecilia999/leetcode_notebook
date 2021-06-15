//思路
//这道题是79题的变种
//只要找到为 “1” 的岛以后，从这里开始搜索这周连通的陆地，也都标识上访问过。每次遇到新的 “1” 且没有访问过，就相当于遇到了新的岛屿了。

class Solution {
  private int rows;
  private int cols;
  private boolean[][] visited;
  
  public int numIslands(char[][] grid) {
      rows = grid.length;
      cols = grid[0].length;
      visited = new boolean[rows][cols];
      int count = 0;
      
      for(int i=0; i<rows; i++){
          for(int j=0; j<cols; j++){
              if(grid[i][j]=='1' && !visited[i][j]){
                  searchIsland(i, j, grid);
                  count++;
              }
          }
      }
      
      return count;
  }
  
  private void searchIsland(int i, int j, char[][] grid){
      if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]!='1' || visited[i][j] == true)
          return;
      visited[i][j]=true;
      searchIsland(i+1, j, grid);
      searchIsland(i, j+1, grid);
      searchIsland(i-1, j, grid);
      searchIsland(i, j-1, grid);
      
  }
}