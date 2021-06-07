//和33题一样，只需要单独处理nums[low]==nums[mid] 和 nums[high]==nums[mid]的情况
//we can have nums[left] == nums[mid] and in that case, the first half could be out of order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) and we have to deal this case separately. 
//需要把low&high移到ascending order的起点
class Solution {
  public boolean search(int[] nums, int target) {
      int low=0, high=nums.length-1;
      
      while(low<=high){
          int mid = low + (high-low)/2;
          
          if(nums[mid] == target)
              return true;
          
          if(nums[low]<nums[mid]){
              if(nums[low]<=target && target<nums[mid])
                  high = mid - 1;
              else
                  low = mid + 1;
          }
          else if(nums[mid]<nums[high]){
              if(nums[mid]<target && target<=nums[high])
                  low = mid + 1;
              else
                  high = high - 1;
          }
          else{
              if(nums[low]==nums[mid])
                  low++;
              if(nums[high]==nums[mid])
                  high--;
          }            
      }
      return false;
  }
}