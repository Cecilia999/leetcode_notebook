// 题目大意
// 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
// 你可以对一个单词进行如下三种操作：
// 插入一个字符
// 删除一个字符
// 替换一个字符
//  
// 示例 1：
// 输入：word1 = "horse", word2 = "ros"
// 输出：3
// 解释：
// horse -> rorse (将 'h' 替换为 'r')
// rorse -> rose (删除 'r')
// rose -> ros (删除 'e')

// 示例 2：
// 输入：word1 = "intention", word2 = "execution"
// 输出：5
// 解释：
// intention -> inention (删除 't')
// inention -> enention (将 'i' 替换为 'e')
// enention -> exention (将 'n' 替换为 'x')
// exention -> exection (将 'n' 替换为 'c')
// exection -> execution (插入 'u')
//  
// 提示：
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成

// 解题思路

// f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

// Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
//         f(i, j) = f(i - 1, j - 1)

// Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
//         f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

//         f(i, j - 1) represents insert operation
//         f(i - 1, j) represents delete operation
//         f(i - 1, j - 1) represents replace operation

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        //base case
        //从空string到变成word1和word2需要多少步
        for(int i=1; i<=len1; i++){
            dp[i][0] = i;
        }
        
        for(int j=1; j<=len2; j++){
            dp[0][j] = j;
        }
        
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        
        return dp[len1][len2];
    }
}