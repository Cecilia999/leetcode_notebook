# 2104. Sum of Subarray Ranges

## problem description

You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.

Constraints:

1 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9

Follow-up: Could you find a solution with O(n) time complexity?

## solution

same idea as 907 sum of subarray minimums

## code

```java
// solution1 brute force
// O(n^2)
// class Solution {
//     public long subArrayRanges(int[] nums) {
//         long res = 0;
//         for(int i=0; i<nums.length; i++){
//             int max = nums[i], min = nums[i];
//             for(int j=i+1; j<nums.length; j++){
//                 max = Math.max(max, nums[j]);
//                 min = Math.min(min, nums[j]);
//                 res += max - min;
//             }
//         }

//         return res;
//     }
// }

// solution2
// use monotonic stack
// O(n)
// sum of subarray ranges = sum of ( subarray maximum - subarray minimum)
//                        = sum of subarray max - sum of subarray min
//                        = which is the same as problem 907
class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        //calculate sumMin
        int[] ple = new int[n];
        int[] nle = new int[n];
        Arrays.fill(ple, -1);
        Arrays.fill(nle, n);

        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                nle[stack.pop()] = i;
            }
            stack.push(i);
        }
        //empty the stack
        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                ple[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();

        //calculate sumMax
        int[] pme = new int[n];
        int[] nme = new int[n];
        Arrays.fill(pme, -1);
        Arrays.fill(nme, n);

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                nme[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                pme[stack.pop()] = i;
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++){
            res += (long)nums[i]*(i-pme[i])*(nme[i]-i);
        }
        for(int i=0; i<n; i++){
            res -= (long)nums[i]*(i-ple[i])*(nle[i]-i);
        }

        return res;
    }
}
```
