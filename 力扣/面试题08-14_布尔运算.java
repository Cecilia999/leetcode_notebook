// 题目大意
// 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。

// 示例 1:
// 输入: s = "1^0|0|1", result = 0
// 输出: 2
// 解释: 两种可能的括号方法是
// 1^(0|(0|1))
// 1^((0|0)|1)

// 示例 2:
// 输入: s = "0&0&0&1^1|0", result = 1
// 输出: 10

// 提示：
// 运算符的数量不超过 19 个

// 解题思路
// 1. 状态定义：
// dp[i][j][result=0/1]表示第i到j个数字计算结果为result的方案数。
// 2. 状态转移：
// 枚举区间分割点，根据分割点的情况讨论左右区间计算结果，方案数增量为左右方案数相乘。

class Solution {
    public int countEval(String s, int result) {
        char[] ch = s.toCharArray();
        int[][][] dp = new int [ch.length][ch.length][2];

        //base case dp[i][i][0]/dp[i][i][1] 
        //if ch[i]==0, dp[i][i][0]=1
        //if ch[i]==1, dp[i][i][1]=1
        //else ch[i]是运算符
        for(int i=0; i<ch.length; i++){
            if(ch[i]=='0'||ch[i]=='1')
                dp[i][i][ch[i]-'0'] = 1;
        }

        //套区间dp模板
        //枚举区间长度len，跳步为2，一个数字一个符号
        for (int len = 2; len <= ch.length; len+=2) {
            //枚举区间起点，数字位，跳步为2
            for (int i = 0; i <= ch.length-len; i+=2) {
                //区间终点，数字位
                int j = i+len;
                //枚举分割点，三种 '&','|', '^'，跳步为2
                for (int k = i+1; k <= j-1; k+=2) {
                    if(ch[k]=='&'){
                        //结果为0有三种情况：0&0，0&1，1&0
                        //结果为1有一种情况：1&1
                        dp[i][j][0] += dp[i][k-1][0]*dp[k+1][j][0] + dp[i][k-1][0]*dp[k+1][j][1] + dp[i][k-1][1]*dp[k+1][j][0];
                        dp[i][j][1] += dp[i][k-1][1]*dp[k+1][j][1];
                    }

                    if(ch[k]=='|'){
                        //结果为0有1种情况：0&0
                        //结果为1有3种情况：1&1，0&1，1&0
                        dp[i][j][0] += dp[i][k-1][0]*dp[k+1][j][0];
                        dp[i][j][1] += dp[i][k-1][1]*dp[k+1][j][1] + dp[i][k-1][0]*dp[k+1][j][1] + dp[i][k-1][1]*dp[k+1][j][0];
                    }

                    if(ch[k]=='^'){
                        //结果为0有2种情况：0&0,1&1
                        //结果为1有2种情况：0&1，1&0
                        dp[i][j][0] += dp[i][k-1][0]*dp[k+1][j][0] + dp[i][k-1][1]*dp[k+1][j][1];
                        dp[i][j][1] += dp[i][k-1][0]*dp[k+1][j][1] + dp[i][k-1][1]*dp[k+1][j][0];
                    }
                }
            }
        }

        return dp[0][ch.length-1][result];
    }
}