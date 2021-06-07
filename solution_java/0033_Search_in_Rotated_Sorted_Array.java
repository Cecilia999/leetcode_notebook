//题目的意思是，输入的有序数组是中间断开的，分为两个有序部分，前面一部分比后面一部分大
//用二分法要多处理两种情况
//现在数组前面一段是数值比较大的数，后面一段是数值偏小的数。
//如果 mid 落在了前一段数值比较大的区间内了，那么一定有 nums[low] < nums[mid]
//如果 mid 落在了后一段数值比较小的区间内了，那么一定有 nums[mid] < nums[high]

class Solution {
  public int search(int[] nums, int target) {
      int low=0, high=nums.length-1;
      
      while(low<=high){
          int mid=low+(high-low)/2;
          if(nums[mid]==target)
              return mid;
          
          //mid 落在了前一段数值比较大的区间内了，那么一定有 nums[low] < nums[mid]
          else if(nums[low]<=nums[mid]){
              if(nums[low]<=target && target <nums[mid])
                  high=mid-1;
              else
                  low=mid+1;
          }

          //如果 mid 落在了后一段数值比较小的区间内了，那么一定有 nums[mid] < nums[high]
          else{
              if(nums[mid]< target && target<=nums[high])
                  low=mid+1;
              else
                  high=mid-1;
          }
      }
      return -1;
  }
}

