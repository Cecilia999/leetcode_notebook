// 题目大意 #
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。问总共有多少条不同的路径？

// 解题思路 #
// 这是一道简单的 DP 题。输出地图上从左上角走到右下角的走法数。
// 由于机器人只能向右走和向下走，所以地图的第一行和第一列的走法数都是 1，地图中任意一点的走法数是 
//dp[i][j] = dp[i-1][j] + dp[i][j-1]

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            dp[i][0]=1;
        }
        
        for(int j=0; j<n; j++){
            dp[0][j]=1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}