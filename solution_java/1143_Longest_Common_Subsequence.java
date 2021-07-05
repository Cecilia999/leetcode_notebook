题目大意 #
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
（也可以不删除任何字符）后组成的新字符串。例如，“ace” 是 “abcde” 的子序列，但 “aec” 不是 “abcde” 的子序列。两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

解题思路 #
这一题是经典的最长公共子序列的问题。解题思路是二维动态规划。假设字符串 text1 和 text2 的长度分别为 m 和 n，
创建 m+1 行 n+1 列的二维数组 dp，定义 dp[i][j] 表示长度为 i 的 text1[0:i-1] 和长度为 j 的 text2[0:j-1] 
的最长公共子序列的长度。先考虑边界条件。当 i = 0 时，text1[] 为空字符串，它与任何字符串的最长公共子序列的长度都是 0，
所以 dp[0][j] = 0。同理当 j = 0 时，text2[] 为空字符串，它与任何字符串的最长公共子序列的长度都是 0，
所以 dp[i][0] = 0。由于二维数组的大小特意增加了 1，即 m+1 和 n+1，并且默认值是 0，
所以不需要再初始化赋值了。

状态转移方程如下：
dp[i][j] = dp[i-1][j-1]+1, when text1[i-1]=text2[j-1]
dp[i][j]= max(dp[i−1][j],dp[i][j−1]) when text1[i−1] != text2[j−1]

// class Solution {
//     public int longestCommonSubsequence(String s1, String s2) {  
//         int[][] dp = new int[s1.length()+1][s2.length()+1];
//         for(int i=1; i<=s1.length(); i++){
//             for(int j=1; j<=s2.length();j++){
//                 if(s1.charAt(i-1)==s2.charAt(j-1)){
//                     dp[i][j] = dp[i-1][j-1]+1;
//                 }
//                 else{
//                     dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
//                 }
//             }     
//         } 
//         return dp[s1.length()][s2.length()];
//     }   
// }

//性能最优
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int row = s1.length(), col = s2.length();
        int[] dp = new int[col+1];
        
        //用diag来update当前row的最大值
        //用prediag来保存之前的dp[j]的值
        for(int i=0; i<row; i++){
            //dp[0]=0
            int diag = 0;
            for(int j=0; j<col; j++){
                int prediag = dp[j+1];
                if(s1.charAt(i)==s2.charAt(j))
                    dp[j+1]=diag+1;
                else dp[j+1]=Math.max(dp[j+1], dp[j]);
                diag=prediag;
            }
        }
        
        return dp[col];
    }
    
}