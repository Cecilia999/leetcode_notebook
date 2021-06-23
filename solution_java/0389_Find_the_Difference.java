//题目要求找出 t 字符串中比 s 字符串多出的一个字符。思路还是利用异或的性质，X^X = 0，
//将 s 和 t 依次异或，最终多出来的字符就是最后异或的结果。

class Solution {
    public char findTheDifference(String s, String t) {
        //依旧initialize to 0 since 0^x = x;
        //initialize 成 t的最后一位也行xince t.length()-1 == s.length();
        
        char c = t.charAt(t.length()-1);
        for(int i=0; i<s.length();i++){
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        
        return c;
    }
}