// 题目大意 #
// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

// 解题思路 #
// 这一题是 DP 的题目，将一个数字分成多个数字之和，至少分为 2 个数字之和，求解分解出来的数字乘积最大是多少。
// 这一题的动态转移方程是 dp[i] = Math.max(dp[i], j*Math.max(i-j, dp[i-j]) ); ，一个数分解成 j 和 i - j 两个数字，
// 或者分解成 j 和 更多的分解数，更多的分解数即是 dp[i-j]，由于 dp[i-j] 下标小于 i ，所以 dp[i-j] 在计算 dp[i] 的时候一定计算出来了。

//j作为1-i其中一个位置时，取i-j作为整体去计算与i-j的乘积，也可以将i-j拆分，那拿到的就是dp[i-j]，但算的都是取j长度的状态
//比如要算10
//j就是你取了这个比如2这个长度，那剩下长度8，长度8也是通过前面这样算来的
//因为j与i-j是对称的
//取2取8算出来都一样的

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], j*Math.max(i-j, dp[i-j]) );
            }
        }
        
        return dp[n];
    }
}