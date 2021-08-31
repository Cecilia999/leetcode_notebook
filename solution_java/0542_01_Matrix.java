// 题目大意
// 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
// 两个相邻元素间的距离为 1 。

// 示例 1：
// 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
// 输出：[[0,0,0],[0,1,0],[0,0,0]]

// 示例 2：
// 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
// 输出：[[0,0,0],[0,1,0],[1,2,1]]

// 提示
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// mat 中至少有一个 0 

// 解题思路
// bfs+queue

class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];        
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i], -1);
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    queue.offer(new int[]{i, j});
                }
                    
            }
        }
        
        while(!queue.isEmpty()){
            int[] index = queue.poll();
            int i=index[0], j=index[1];
            for(int[] dir : dirs){
                int nexti = i+dir[0], nextj = j+dir[1];
                 if(nexti>=0 && nexti<m && nextj>=0 && nextj<n && dist[nexti][nextj]==-1){
                     dist[nexti][nextj] = dist[i][j] + 1;
                     queue.offer(new int[] {nexti, nextj});
                 }
            }   
        }
        
        return dist;
    }
}