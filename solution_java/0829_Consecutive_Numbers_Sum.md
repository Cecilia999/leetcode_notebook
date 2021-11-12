# Consecutive Numbers Sum

## 题目大意

Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.

Example 1:
Input: n = 5
Output: 2
Explanation: 5 = 2 + 3

Example 2:
Input: n = 9
Output: 3
Explanation: 9 = 4 + 5 = 2 + 3 + 4

## 解题思路

数学求等差数列

(x+1) + (x+2) + ... + (x+k) = N
according to arithmetic sequence equation we have
(x+1 + x+k) \* k/2 = N for x>0, k>=1
(2x + k + 1) \* k = 2N for x>0, k>=1
we need to solve this equation to find valid x,k pairs

k < 2x + k + 1
k^2 < 2N
1 <= k < sqrt(N)
for each k, find valid x, which means find x that are positive integer.
if(x) is positive integer, counts++;

(x+1) + (x+2) + ... + (x+k) = N
kx + (1+k)*k/2 = N
kx = N - (1+k)*k/2
x = (N - (1+k)\*k/2) % == 0 **-->>** count++

## code

```java
class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for(int k = 1; k<Math.sqrt(2*n); k++){
            if((n - (k+1)*k/2) % k == 0) count++;
        }

        return count;
    }
}
```
