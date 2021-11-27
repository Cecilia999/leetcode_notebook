# 287. Find the Duplicate Number

## problem

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?

## solution

- time complexity: O(nlog(n))
- space: O(1)

1. binary search: [1-n]
2. 对于每个 mid，count the amount of nums[i]<=mid
   - if the count>mid, 说明[low-mid]的区间有 duplicate
   - vice versa

## code

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int count = 0;
            for(int num : nums){
                if(num<=mid) count++;
            }

            //duplicate is in [low, mid]
            if(count>mid)
                high = mid-1;
            else
                low = mid+1;
        }

        return low;
    }
}
```
