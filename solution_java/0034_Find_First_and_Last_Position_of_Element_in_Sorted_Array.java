//思路：
//这道题是二分法变种的：二分查找第一个与 target 相等的元素 + 二分查找最后一个与 target 相等的元素集合
//注意：一次二分查找只能找到一个
//所以写两个function分别查找第一个和最后一个

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];
        pos[0] = findFristTarget(nums, target);
        pos[1] = findLastTarget(nums, target);
        return pos;
    }
    
    private int findFristTarget(int[] nums, int target){
        int low=0, high=nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]<target){
                    return mid;
                }
                high = mid-1;
            }
            
            else if(nums[mid]>target)
                high=mid-1;
            else
                low = mid+1;
        }
        
        return -1;
    }
    
    private int findLastTarget(int[] nums, int target){
        int low=0, high=nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target){
               if(mid==nums.length-1 || nums[mid+1]>target){
                    return mid;
                }
                low = mid+1;
            }
            
            else if(nums[mid]>target)
                high=mid-1;
            else
                low = mid+1;
        }
        
        return -1;
    }
}