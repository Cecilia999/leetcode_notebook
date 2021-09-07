// 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
// 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
// 注意：该题与 1081 相同
// Return the lexicographically smallest subsequence of s that contains 
// all the distinct characters of s exactly once.

// 示例 1：
// 输入：s = "bcabc"
// 输出："abc"

// 示例 2：
// 输入：s = "cbacdcbc"
// 输出："acdb"
//  
// 提示：
// 1 <= s.length <= 104
// s 由小写英文字母组成

// 解题思路

// 为了得到最小字典序的方法和402题的思路一样
// 如果s[i]<s[i-1],去掉s[i-1]可以让s的字典序变小

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastPosition = new int[26];
        
        //找出每个字母最后出现的位置
        for(int i=0; i<s.length(); i++){
            lastPosition[s.charAt(i)-'a']=i;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<s.length(); i++){
            int letter = s.charAt(i) - 'a';
            
            //if stack already exsit letter, skip
            if(set.contains(letter))
                continue;
            
            //如果s[i]<s[i-1]&&s[i-1]的lastposition在i后面
            while(!stack.isEmpty() && letter<stack.peek() && i<lastPosition[stack.peek()]){
                set.remove(stack.peek());
                stack.pop();
            }
            
            stack.push(letter);
            set.add(letter);
        }
        
        StringBuilder sb =  new StringBuilder();
        for(int i : stack){
            char c = (char)(i + 'a');
            sb.append(c);
        }
        
        return sb.toString();
    }
}