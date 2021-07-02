//这道题只求连续的上升子序列，所以只需要一个for loop, 对比i和i-1
//不需要用数组动态维护，只需要两个值 length用来维护当前的递增子序列长度，max用来更新目前为止的最长递增子序列长度
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = 1, max = 1;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1])
                length++;
            else{
                max = Math.max(max, length);
                length = 1;
            }
        }
        
        return Math.max(max, length);
    }
}