//题目大意 
//后缀表达式的计算方法

//解题思路
//如果为数字则入栈，如果为符号则将前面两个数字出栈，先出栈的在右边后出栈的在左边符号放中间算出来结果再扔到栈中即可。

//要用s.equals("+") -->> s=="+"会一直return false

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        
        for(String s : tokens){
            if(s.equals("+")){
                a=stack.pop();
                b=stack.pop();
                stack.add(b + a);
            }
            else if (s.equals("-")){
                a=stack.pop();
                b=stack.pop();
                stack.add(b - a);
            }
            else if (s.equals("*")){
                a=stack.pop();
                b=stack.pop();
                stack.add(b * a);
            }
            else if(s.equals("/")){
                a=stack.pop();
                b=stack.pop();
                stack.add(b / a);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
}