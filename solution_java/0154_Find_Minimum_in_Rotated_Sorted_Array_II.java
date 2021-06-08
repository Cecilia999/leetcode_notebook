//思路参照153，就是把nums[low]==nums[mid]分开来处理

class Solution {
  public int findMin(int[] nums) {
      int low=0, high=nums.length-1;
      
      while(low<high){
          if(nums[low]<nums[high])
              return nums[low];
          int mid = low + (high-low)/2;
          
          
          if(nums[low]<nums[mid])
              low  = mid+1;
          //有重复
          else if(nums[low]==nums[mid])
              low++;
          else 
              high=mid;
      }
      
      return nums[low];
  }
}