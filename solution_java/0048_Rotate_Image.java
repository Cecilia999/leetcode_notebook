// 题目大意
// 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
// 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

// 解题思路
// 先水平翻转：matrix[row][col] = matrix[n−row−1][col]
// 后沿对角线翻转：matrix[row][col] = matrix[col][row]


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //水平翻转
        //注意row<n/2
        for(int row=0; row<n/2; row++){
            for(int col=0; col<n; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n-1-row][col];
                matrix[n-1-row][col] = temp;
            }
        }
        
        //对角线翻转
        //注意只用翻转对角线的一边
        for(int row=0; row<n; row++){
            for(int col=row; col<n; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        
        return;
    }
}