# 正则表达式匹配

### 题目大意

给你一个字符串  s  和一个字符规律  p，请你来实现一个支持 '.'  和  '\*'  的正则表达式匹配。

'.' 匹配任意单个字符
'\*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖   整个   字符串  s 的，而不是部分字符串。

示例 1：

输入：s = "aa" p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

示例 2:

输入：s = "aa" p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例  3：

输入：s = "ab" p = "._"
输出：true
解释："._" 表示可匹配零个或多个（'\*'）任意字符（'.'）。
示例 4：

输入：s = "aab" p = "c*a*b"
输出：true
解释：因为 '\*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5：

输入：s = "mississippi" p = "mis*is*p\*."
输出：false

提示：

0 <= s.length <= 20
0 <= p.length <= 30
s  可能为空，且只包含从  a-z  的小写字母。
p  可能为空，且只包含从  a-z  的小写字母，以及字符  .  和  *。
保证每次出现字符  * 时，前面都匹配到有效的字符

### 解题思路

**状态**
首先状态 dp 一定能自己想出来。
dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配

**转移方程**
怎么想转移方程？首先想的时候从已经求出了 dp[i-1][j-1] 入手，再加上已知 s[i]、p[j]，要想的问题就是怎么去求 dp[i][j]。

已知 dp[i-1][j-1] 意思就是前面子串都匹配上了，不知道新的一位的情况。  
那就分情况考虑，所以对于新的一位 p[j] s[i] 的值不同，要分情况讨论：

1. 考虑最简单的 p[j] == s[i] : dp[i][j] = dp[i-1][j-1]

然后从 p[j] 可能的情况来考虑，让 p[j]=各种能等于的东西。

2. p[j] == "." : dp[i][j] = dp[i-1][j-1]

3. p[j] =="\*":

**3.1 p[j-1] != s[i] ‘\*’ 和前面那个元素一起当作 empty** : dp[i][j] = dp[i][j-2]

**3.2 p[j-1] == s[i] or p[j-1] == "."**:

1.  dp[i][j] = dp[i-1][j] e.g. stttx st\*x //多个字符匹配的情况
2.  or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
3.  or dp[i][j] = dp[i][j-2] // 没有匹配的情况

```java
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        //初始化第一行，s==null的时候 只有p=="*"才有可能 dp==true
        dp[0][0] = true;
        dp[0][1] = false;
        for(int j=2; j<=p.length(); j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-2];
            }

        }

        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){

                //p[j]==s[i] or p[j]=='.'
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];

                //除了以上情况，只有当p[j]=='*' p还有匹配s的可能
                else if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2)=='.'){
                        dp[i][j] =  dp[i-1][j] ||        // 多个字符匹配的情况
                                    dp[i][j-1] ||        // 单个字符匹配的情况
                                    dp[i][j-2];          // 没有匹配的情况
                    }
                    else if( p.charAt(j-2) != s.charAt(i-1))
                        dp[i][j] = dp[i][j-2];           //'*'带着他的前面一个字母一起消失

                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
```
