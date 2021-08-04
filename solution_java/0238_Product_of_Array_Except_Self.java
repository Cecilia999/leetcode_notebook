// 题目大意
// 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
// 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// 解题思路
// res[i] = 当前nums[i]左边数的乘积 * 当前nums[i]右边数的乘积

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        
        //先把res[i] = nums[i]左边的元素相乘
        for(int i=1; i<nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        
        int right = 1;
        //再倒着把res[i] = nums[i]右边的元素相乘
        for(int i=nums.length-1; i>=0; i--){
            res[i] *= right;   //最右的右边没有元素，所以乘以1
            right *= nums[i];
        }
        
        return res;
    }
}