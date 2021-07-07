// 题目大意 #
// 括号匹配问题。

// 解题思路 #
// 遇到左括号就进栈push，遇到右括号并且栈顶为与之对应的左括号，就把栈顶元素出栈。
// 如果遇到右括号但是stack is empty，return false；
// 最后看栈里面还有没有其他元素，如果为空，即匹配。
// 需要注意，空字符串是满足括号匹配的，即输出 true。

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else if(stack.empty()) return false;
            else if(c==')'){
                if(stack.pop()!='(')
                    return false;
            }
            else if(c=='}'){
                if(stack.pop()!='{')
                    return false;
            }
            else if( c==']'){
                if(stack.pop()!='[')
                    return false;
            }
        }
        
        if(!stack.empty())
            return false;
        
        return true;
    }
}