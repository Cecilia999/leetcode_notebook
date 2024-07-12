# 263. Ugly Number

https://leetcode.com/problems/ugly-number/description/

## Solution

```java
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        // 如果 n 是丑数，分解因子应该只有 2, 3, 5
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        // 如果能够成功分解，说明是丑数
        return n == 1;
    }
}

```