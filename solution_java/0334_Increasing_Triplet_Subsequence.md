# 334. Increasing Triplet Subsequence

## Problem Description

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1

Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?

## Solution

//go check this answer
//https://leetcode.com/problems/increasing-triplet-subsequence/solutions/1346386/thought-process-step-wise-from-brute-force-to-optimal-solution/?envType=study-plan-v2&envId=leetcode-75

My version answer is for each num inside the array,
1. find the min number located in its left
2. find the maximum number located in it right
3. compare if left min < num < right max

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        //utilize bruce force
        //Time Complexity: O(N)
        //Space Complexity: O(N)
        int len = nums.length;
        
        //find the left min for each num
        int left[] = new int[len];
        left[0] = nums[0];
        for(int i=1; i<len; i++){
            left[i] = Math.min(nums[i-1], left[i-1]);
        }

        //find the right max for each num
        int right[] = new int[len];
        right[len-1] = nums[len-1];
        for(int i=len-2; i>0; i--) {
            right[i] = Math.max(nums[i+1], right[i+1]);
        }

        //check if each num[i] is larger than its left min and less than its right max
        for(int i=0; i<len; i++) {
            if(left[i]<nums[i] && nums[i]<right[i]) {
                return true;
            }
        }

        return false;
    }
}
```