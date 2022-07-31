# 16. 3Sum Closest

## Description

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104

## Solution

思路和3sum一样，先要sort array
对于每个数我们去找另外两个可以更新closestSum的数

## code

```java
//Runtime: 83 ms
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE; //用来保存closestSum的绝对值，用abs value进行比较
        int res = target; //用来保存实际值
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            int left = i+1, right = nums.length-1;
            
            while(left<right){
                if(Math.abs(nums[left]+nums[right]+nums[i]-target)<closestSum){
                    closestSum = Math.abs(nums[left]+nums[right]+nums[i]-target);
                    res = nums[left]+nums[right]+nums[i];
                }
                if(nums[left]+nums[right]+nums[i] == target)
                    return target;
                else if(nums[left]+nums[right]+nums[i]<target)
                    left++;
                else
                    right--;
            }
        }
        
        return res;
    }
}
```