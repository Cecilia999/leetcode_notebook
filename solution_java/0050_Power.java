// 题目大意 #
// 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
// 保证base和exponent不同时为0。不用考虑小数点后面0的位数。
// -100.0 < base < 100.0
// -2^31 <= exponent <= 2^31-1
// -10^4 <= base^exponent <= 10^4

// 解题思路 #
// 递归 + 快速倍乘
// 需要处理注意 exponent 的正负数，按照exponent 的奇偶性来指数倍乘 
// exponent是负数的话 利用 base=1/base exponent = -exponent
// 但是需要处理 exponent = Integer.MIN_VALUE 的情况，exponent = -exponent会导致overflow
// 时间复杂度 O(log n)
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent==0) //bottom case, 不断的exponent/2最终 exponent会等于0
            return 1;
        if(exponent<0){
            if(exponent==Integer.MIN_VALUE){
                base *= base;
                exponent /= 2;
            }
            exponent = -exponent;
            base = 1/base;
        }
        
        if(exponent%2==0)
            return Power(base*base, exponent/2);
        else
            return base*Power(base*base, exponent/2);
  }
}