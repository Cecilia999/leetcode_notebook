// 题目大意
// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

// 输入: 1
// 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 输入: 2
// 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]

// 解题思路：
// 动态规划 dp[i][j] = 扔i个骰子点数和为j的次数
// 动态转化方程为：
// for (第n枚骰子的点数 cur = 1; cur <= 6; curi ++) {
//     dp[n][j] += dp[n-1][j - cur]
// }
// 比如i=2，j=10 -->> dp[2][10] = 第二次扔cur=1到6的次数 + 第一次仍10-cur的次数

class Solution {
    public double[] dicesProbability(int n) {

        //dp[i][j] = 扔i个骰子点数和为j的次数
        int[][] dp = new int[n+1][6*n+1];
        for(int i=1; i<=6; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){

            //注意 j从i开始，如i=3个骰子，那么点数j最小从3开始
            for(int j=i; j<=6*i; j++){
                //比如i=2，j=10
                //dp[2][10] = 第二次扔cur=1到6的次数 + 第一次仍10-cur的次数
                for(int cur = 1; cur<=6  && cur<=j; cur++){
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }
    
        //2个以上的骰子，起始点数为n
        //如 n=2，点数范围2～12；n=3，点数范围3～16； n=n, 点数范围n～6*n
        //范围长度 6*n - n + 1
        double[] res = new double[6*n - n+1];
        double all = Math.pow(6, n);
        for(int k=n; k<=6*n; k++){
            res[k-n] = dp[n][k] * 1.0 / all;
        }

        return res;
    }
}