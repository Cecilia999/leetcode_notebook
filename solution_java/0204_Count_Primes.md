# 204. Count Primes

https://leetcode.com/problems/count-primes/description/

## Solution

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;

        //we only need to count until sqrt(n)
        //because if we observe divisors of 12
        //12 = 2 x 6
        //12 = 3 x 4
        //12 = sqrt(12) x sqrt(12)
        //12 = 4 x 3
        //12 = 6 x 2
        //so sqrt(n) is a divider
        for(int i=2; i * i < n; i++) {
            if(isPrime[i]) {
                //we only need to start with i^2, becasue
                //when n = 25，i = 5
                //for isPrime[10] or isPrime[15], 
                //they have already marked = false when i = 2 or i = 3
                for(int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2; i<n; i++) {
            if(isPrime[i]) count++;
        }

        return count;
    }
}
```