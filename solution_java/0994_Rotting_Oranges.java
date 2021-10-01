// 题目大意
// 在给定的网格中，每个单元格可以有以下三个值之一：

// 值 0 代表空单元格；
// 值 1 代表新鲜橘子；
// 值 2 代表rotten orange腐烂的橘子。

// 解题思路
// bfs+queue
// 像127. word ladder一样

//用queue+bfs
//不要用recursion！
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        //把rotten放入queue
        //计算fresh的总数
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        
        if(fresh==0) return 0;
        
        int count = 0; //count # of elapse
        while(!queue.isEmpty()){
            //bfs+queue!!!!!!!!
            count++;
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] rotten = queue.poll();
                for(int[] dir : directions){
                    int row = rotten[0] + dir[0];
                    int col = rotten[1] + dir[1];

                    if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1)
                        continue;

                    grid[row][col]=2;
                    fresh--;  //fresh becomes rotten
                    queue.offer(new int[]{row, col});
                }
            }
            
        }
        
        return fresh==0? count-1 : -1; //第一层多数了
    }
}