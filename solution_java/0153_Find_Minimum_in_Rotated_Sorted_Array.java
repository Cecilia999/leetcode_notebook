//思路：
//给出一个原本从小到大排序过的数组，但是在某一个分割点上，把数组切分后的两部分对调位置，数值偏大的放到了数组的前部。求这个数组中最小的元素。
//求数组最小的元素其实就是找分割点！！！！！
//前一个数比当前数大，后一个数比当前数也要大。

//关于条件是low<high 还是 low<=high
//low<high: return nums[low] 在while loop的外面
//low<=high： return在while loop里面

//You use while (start <= end) if you are returning the match from inside the loop.
//You use while (start < end) if you want to exit out of the loop first, and then use the result of start or end to return the match.

//这题和33&81的逻辑差不多
//判断切割点pivot的条件是：
//if mid落在了前面的部分，我们确定pivot一定在mid的右边
//  low=mid+1
//else，mid落在了后面的部分，我们确定pivot一定<=mid,因为pivot本身就在后面的部分
//  high=mid

//先判断当 nums[low]<nums[high]时，nums[low]就是pivot
//这个判断条件可以解决如[11, 13, 15, 17]这样的edge case

//再判断mid落在了前面部分的条件：
//if(nums[low]<=nums[mid]) 
//else落在了后面的部分
class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        
        while(low<high){
            if(nums[low]<nums[high])
                return nums[low];
            int mid = low + (high-low)/2;
            
            if(nums[low]<=nums[mid])
                low = mid + 1;
            else 
                high = mid;
        }
        return nums[low];
    }
}