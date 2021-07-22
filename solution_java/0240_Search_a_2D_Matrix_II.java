// 题目大意 #
// 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。

// 两种思路
// 一种是：
// 把每一行看成有序递增的数组，
// 利用二分查找，
// 通过遍历每一行得到答案，
// 时间复杂度是nlogn

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            if(searchArr(matrix[i], target))
                return true;
        }
        return false;
    }
    
    public boolean searchArr(int[] nums, int target){
        int low = 0, high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}

// 另外一种思路是：
// 利用二维数组由上到下，由左到右递增的规律，
// 那么选取右上角或者左下角的元素a[row][col]与target进行比较，
// 当target大于元素a[row][col]时，那么target必定在元素a所在列的左边,
// 即col--；
// 当target小于元素a[row][col]时，那么target必定在元素a所在行的下边,
// 即row++；

class Solution{
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                col--;
            else
                row++;
        }
        return false;
    }
}