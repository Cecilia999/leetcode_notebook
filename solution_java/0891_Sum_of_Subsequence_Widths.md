# 891. Sum of Subsequence Widths (难，要注意的细节多，多刷几次)

## problem

The width of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums. Since the answer may be very large, return it modulo 109 + 7.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [2,1,3]
Output: 6
Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

Example 2:

Input: nums = [2]
Output: 0

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105

## solution

brute force 的 time complexity 是 O(2^n)
肯定会超时, 最多的 time complexity 只能是 O(nlogn)

1. key observation1: order does not matters

[2,1,3]:[1],[2],[3],[2,1],[2,3],[1,3],[2,1,3]
[1,2,3]:[1],[2,[3],[1,2],[2,3],[1,3],[1,2,3]

2. key observation2:

Every numbers contribute based on its index in the sorted array:

A[i] contributes if it's on left(smallest)or on the right(largest).
[1,2,3]:[2],[1,2],[2,3]

In a sorted array, there are i numbers <=A[i] and n-i-1 numbers >=A[i]

- A[i] will be the upper bound of 2^i subsequences
- A[i] will be the lower bound of 2^(n-i-1) subsequences

A[i]'s contribution: A[i] x 2^i - A[i] x 2^(n-i-1)

3. Ans=Sum(A[i] x 2^i - A[i] x 2^(n-i-1)), 0<=i<n
   = (A[0]x2^0 - A[0]x2^(n-0-1) + (A[1]x2^1 - A[1]x2^(n-1-1) + ... +
   ( _A[i]x2^i_ - A[i]x2^(n-i-1) ) + ... + ( A[n-i-1]x2^(n-i-1) - _A[n-i-1]x2^i_ )

   = **A[i]x2^i - A[n-i-1]x2^i** + **A[n-i-1]x2^(n-i-1) - A[i]x2^(n-i-1)**

   Ans=Sum( A[i] x 2^i - A[n-i-1] x 2^(i) ), 0<=i<n

## code

```java
class Solution {
    public int sumSubseqWidths(int[] nums) {
        //brute force的time complexity 是 O(2^n)
        //肯定会超时, 最多的time complexity只能是O(nlogn)

        int n = nums.length;
        Arrays.sort(nums);
        long sum = 0, mod = (long)1e9 + 7, d=1;

        for(int i=0; i<nums.length; i++){
            long upperbound = (nums[i] * d);
            long lowerbound = (nums[n-i-1] * d);
            sum = (sum + upperbound - lowerbound) % mod;
            d = d * 2 % mod;
        }

        //add mod to ensure the return is positive
        return (int) ((sum + mod) % mod);
    }
}
```
