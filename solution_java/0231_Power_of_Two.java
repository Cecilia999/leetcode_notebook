//思路：
//用loop/2可以实现，但题目要求不用loop，可以用bit manipulation

//note that power of 2 has only one bit equal to 1 
// This is classical bit manipulation problem for n & (n-1) trick, which removes the last non-zero bit from our number

// example:
// 1.n = 100000, then n - 1 = 011111 and n & (n-1) = 000000, so if it is power of two, result is zero
// 2.n = 101110, then n - 1 = 101101 and n & (n-1) = 101100, number is not power of two and result is not zero.


class Solution {
    public boolean isPowerOfTwo(int n) {
        return ( n>0 && (n&(n-1)) == 0);
        //return ( n>0 && Math.pow(2,31) % n == 0);
        //return Integer.bitCount(num)==1;
    }
}