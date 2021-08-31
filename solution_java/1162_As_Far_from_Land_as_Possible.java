// 题目大意
// 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
// 如果网格上只有陆地或者海洋，请返回 -1。

// 输入：[[1,0,1],[0,0,0],[1,0,1]]
// 输出：2
// 解释： 
// 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。

// 输入：[[1,0,0],[0,0,0],[0,0,0]]
// 输出：4
// 解释： 
// 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。

// 解题思路
// bfs+queue 和542题一样

class Solution {
    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1},{0, 1}};
    
    public int maxDistance(int[][] grid) {
        int maxDist = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i], -1);
        }
        
        Queue<int[]> q = new LinkedList<int[]> ();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        
        if(q.size()==m*n || q.size()==0) return -1;
        
        while(!q.isEmpty()){
            int[] nums = q.poll();
            int i=nums[0], j=nums[1];
            for(int[] dir : dirs){
                int ni = i + dir[0];
                int nj = j + dir[1];
                
                if(ni>=0 && ni<m && nj>=0 && nj<n && dist[ni][nj]==-1){
                    dist[ni][nj] = dist[i][j]+1;
                    maxDist = Math.max(maxDist, dist[ni][nj]);
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        
        return maxDist;
    }
}