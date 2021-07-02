// 题目大意 #
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

// 解题思路 #
// 这一题是第 62 题的加强版。也是一道考察 DP 的简单题。
// 这一题比第 62 题增加的条件是地图中会出现障碍物，障碍物的处理方法是 dp[i][j]=0。
// 需要注意的一种情况是，起点就是障碍物，那么这种情况直接输出 0 。

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        dp[0][0]=obstacleGrid[0][0]==1? 0:1;
        
        //edge case:
        //对于dp[0][j], dp[i][0]的node如果他的前一个node放了障碍物或者dp[][]==0
        //那这条路就走不通
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0]!=1 && dp[i-1][0]!=0) 
                dp[i][0]=1;
        }
        for(int j=1; j<n; j++){
            if(obstacleGrid[0][j]!=1 && dp[0][j-1]!=0) 
                dp[0][j]=1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                
            }
        }
        
        return dp[m-1][n-1];
    }
}