//852题的加强版，不止一个山峰而是多个山峰
//但解法一样
class Solution {
  public int findPeakElement(int[] nums) {
      int low=0, high=nums.length-1;
      
      while(low<high){
          int mid=low+(high-low)/2;
          
          //peak is in the left
          if(nums[mid]>=nums[mid+1])
              //因为peak可能就是arr[mid], high=mid-1会skip掉
              high=mid;
          
          //peak is in the right
          else
              low = mid + 1;
      }
      
      return low;
  }
}