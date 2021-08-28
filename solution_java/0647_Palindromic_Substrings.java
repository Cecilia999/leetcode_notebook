// 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

// 示例 1：
// 输入："abc"
// 输出：3
// 解释：三个回文子串: "a", "b", "c"

// 示例 2：
// 输入："aaa"
// 输出：6
// 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

// 解题思路
// 中心拓展，从i到s.length，以i，i / i-1，i为中心向两端扩展判断是否为回文，找到一个count++

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++){
            res += extendPalindrome(s, i, i);
            if(i>0)
                res += extendPalindrome(s, i-1, i);
        }
        
        return res;
    }
    
    private int extendPalindrome(String s, int i, int j){
        int count = 0;
        
        //stop counting palindrome once any of these three conditions is not satisfied;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            count++;
        }
        
        return count;
    }
}