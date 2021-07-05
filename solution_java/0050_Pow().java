// 题目大意 #
// 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

// 解题思路 #
// 要求计算 Pow(x, n)
// 这一题用递归的方式，不断的将 n 2 分下去。注意 n 的正负数，n 的奇偶性 以及 n太小overflow

// 时间复杂度 O(log n),空间复杂度 O(1)
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1; //所有数字的0次方都是1
        }
        if(n == Integer.MIN_VALUE){ //overflow edge case
            x *= x;
            n /= 2;
        }
        if(n < 0){
            n=-n;
            x= 1/x;
        }
        
        if(n%2==0){
            return myPow( x*x, n/2);
        }
        else{
            return x*myPow( x*x, n/2);
        }
    }
}