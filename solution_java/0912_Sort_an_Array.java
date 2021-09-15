// 题目大意
// Given an array of integers nums, sort the array in ascending order.

//1. quick sort
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);     
        return nums;
    }
    
    private void quickSort(int[] nums, int start, int end){
        if(start>=end)
            return;
        
        int pivot = start, l=start, r=end;
        
        while(l<r){
            
            while(nums[r]>=nums[pivot] && l<r)
                r--;
            while(nums[l]<=nums[pivot] && l<r)
                l++;
            
            //把nums[r]和nums[l]互换位置
            if(l<r){
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
            }
            
        }
        
        //把nums[l]和pivot互换位置
        int temp = nums[pivot];
        nums[pivot] = nums[l];
        nums[l] = temp;
        
        quickSort(nums, start, l-1);
        quickSort(nums, l+1, end);
    }
       
}