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
    public int max=0;
    public int start=0;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            isPalindromic(i, i, s);
            if(i>0)
                isPalindromic(i-1, i, s);
            
        }
        
        return s.substring(start, start+max);
    }
    
    public void isPalindromic(int left, int right, String s){
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        
        left++;
        right--;
        
        if(max < right-left+1){
            max = right-left+1;
            start = left;
        }
    }
}

