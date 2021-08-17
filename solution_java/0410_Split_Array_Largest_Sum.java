// 题目大意
// 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
// 设计一个算法使得这 m 个子数组各自和的最大值最小。

// 示例 1：
// 输入：nums = [7,2,5,10,8], m = 2
// 输出：18
// 解释：
// 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
// 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。

// 示例 2：
// 输入：nums = [1,2,3,4,5], m = 2
// 输出：9

// 示例 3：
// 输入：nums = [1,4,4], m = 3
// 输出：4
//  
// 提示：
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= m <= min(50, nums.length)

//解题思路
//二分法最大值最小化问题

class Solution {
    public int splitArray(int[] nums, int m) {
        //1. 找到子数组和的lowerBound 和 upperBound
        int low = nums[0], high=nums[0];
        for(int i=1; i<nums.length; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = low + (high-low)/2;

            if(findSplit(nums, mid) > m) //说明mid太小了
                low = mid + 1;
            else
                high = mid -1;
        }

        return low;
    }

    private int findSplit(int[] nums, int sum){
        int count = 1, total=0;  //count至少为1

        for(int i=0; i<nums.length; i++){
            total += nums[i];
            if(total > sum) { //当total>设置的最小分组和时
                total = nums[i];
                count++;
            }
        }

        return count;
    }
}