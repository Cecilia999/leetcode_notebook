// 题目大意
// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
// 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

// 解题思路
// 这题和343 integer break一样，但是加了一个取模的条件，dp会溢出
// 直接用数学结论： 尽可能把绳子分成长度为3的小段，这样乘积最大
// 步骤如下：

// 1. 如果 n == 2，返回1，
// 2. 如果 n == 3，返回2，
// 3. 如果 n == 4，返回4
// 4. 如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；
// 最后返回时乘以小于等于4的最后一小段；每次乘法操作后记得%1000000007就行
// 以上1和2可以合并, return n-1

class Solution {
    public int cuttingRope(int n) {
        if(n<=3) //n==2,3
            return n-1;
        
        //int 会溢出！！
        long res = 1;
        while(n>4){
            res = res * 3 % 1000000007;
            n -= 3;
        }

        return (int) (res * n % 1000000007);    //！
    }
}