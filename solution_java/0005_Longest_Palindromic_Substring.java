// 题目大意
// 给你一个字符串 s，找到 s 中最长的回文子串。

// 示例 1：
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。

// 示例 2：
// 输入：s = "cbbd"
// 输出："bb"

// 解题思路
// 中心拓展法 和647题一样

class Solution {
    int low = 0;
    int maxLen = 0;
    
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            checkPalindrome(s, i, i);
            if(i>0){
                checkPalindrome(s, i-1, i);
            }
        }
        
        return s.substring(low, low + maxLen);
    }
    
    private void checkPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        //i和j多--和++了一次！！
        if(maxLen<j-i-1){
            low = i+1;
            maxLen = j-i-1;
        }
    }
}