// 题目大意 #
// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。说明：每次只能向下或者向右移动一步。

// 解题思路 #
// 在地图上求出从左上角到右下角的路径中，数字之和最小的一个，输出数字和。
// 这一题最简单的想法就是用一个二维数组来 DP，当然这是最原始的做法。
// 由于只能往下和往右走，只需要维护 2 列信息就可以了，从左边推到最右边即可得到最小的解。
// 更近一步，可以直接在原来的数组中做原地 DP，空间复杂度为 0 。
//dp[i][j]代表到[i,j]的minimum path summ

//解法1
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        //rows
        for(int i=1; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        
        //cols
        for(int i=1; i<m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m-1][n-1];
    }
}

//解法2
//优化memory usgae, 原地DP, 直接用grid[][]代替dp[][]
class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length, col=grid[0].length;
        
        for(int i=1; i<row; i++){
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1; i<col; i++){
            grid[0][i]+=grid[0][i-1];
        }
         
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                grid[i][j]=Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j]; 
            }
        }
        
        return grid[row-1][col-1];
    }
}