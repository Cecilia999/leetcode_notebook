# 1390. Four Divisors

## problem

Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
Example 2:

Input: nums = [21,21]
Output: 64
Example 3:

Input: nums = [1,2,3,4,5]
Output: 0

Constraints:

1 <= nums.length <= 104
1 <= nums[i] <= 105

## solution

math + factor
**用 sqrt() 优化**

1492. The kth Factor of n 同理

corner case：

1. num<5, 没有 4 个 divisor
2. divisor>5 个的停止寻找，因为只要正好 4 个

##

```java
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num : nums){
            //corner case
            if(num<6) continue;

            sum += findDivisorSum(num);
        }

        return sum;
    }

    public int findDivisorSum(int n){
        int sqrt = (int)Math.sqrt(n);
        //corner case: 能完全平方的数字的divisor一定是奇数个
        //e.g 4 --> 1, 2, 2, 4
        if(sqrt * sqrt == n ) return 0;

        //1和这个数本身一定是他的因子
        // int sum = 1 + n;
        // int count = 2;

        int sum=0, count=0;

        for(int i=1; i<=sqrt; i++){
            if(count==5) return 0;

            if(n%i==0){ //factor一次找到一对
                sum += (i + n/i);
                count+=2;
            }
        }

        return count==4? sum : 0;
    }
}
```
