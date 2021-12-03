# 7. Reverse Integer

## problem

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0

Constraints:

-231 <= x <= 231 - 1

## solution

用 sign 保留符合
x = abs(x)
while(x>0){
判断 res\*10 + x%10 会不会超过 MAX_VALUE，会的话 return 0
}

## code

```java
class Solution {
    public int reverse(int x) {
        if(x==0)
            return 0;

        int res = 0;
        int sign = x>0? 1:-1;
        x = Math.abs(x);

        while(x>0){
            //check over flow
            if(Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - x%10) < res*10)
                return 0;

            res = res*10 + x%10;
            x /= 10;
        }
        return sign * res;

    }
}
```
