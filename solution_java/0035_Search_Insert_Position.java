//二分法变种之 查找最后一个小于等于target 的元素
//如果找到查找最后一个小于等于target 就return tagret的index
//找不到target就return最后一个小于target的index+1

class Solution {
  public int searchInsert(int[] nums, int target) {
      int low=0, high=nums.length-1;
      
      while(low<=high){
          int mid = low + (high-low)/2;
          
          if(nums[mid]==target) return mid;
          else if(nums[mid]<target){
              //判断是不是最后一个小于等于target
              if(mid==nums.length-1 || nums[mid+1]>target){
                  return mid+1;
              }
              //不是第一个 decrease high
              low=mid+1;
              
          }
          
          else{
              //nums[mid]>target, decrease high
              high=mid-1;
          }
      }
      return low;
  }
}