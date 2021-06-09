public class Solution {
  public int GetNumberOfK(int [] array , int k) {
      
      int first = findFirstTargetPosition(array, k);
      int last = findLastTargetPosition(array, k);
      
      if(first==-1 && last==-1)
          return 0;
      return last-first+1;
  }
  
  private int findFirstTargetPosition(int [] nums , int target){
      int low=0, high=nums.length-1;
      
      while(low<=high){
          int mid = low + (high-low)/2;
          
          //找到target判断是不是第一个target
          if(nums[mid]==target){
              if(mid==0 || nums[mid-1]<target)
                  return mid;
              else
                  high = mid-1;
          }
          else if(nums[mid]<target){
              low = mid+1;
          }
          else{
               high = mid-1;
          }
      }
      return -1;
  }
  
  private int findLastTargetPosition(int [] nums , int target){
      int low=0, high=nums.length-1;
      
      while(low<=high){
          int mid = low + (high-low)/2;
          
          //找到target判断是不是最后一个target
          if(nums[mid]==target){
              if(mid==nums.length-1 || nums[mid+1]>target)
                  return mid;
              else
                  low = mid+1;
          }
          else if(nums[mid]<target){
              low = mid+1;
          }
          else{
               high = mid-1;
          }
      }
      return -1;
  }
}