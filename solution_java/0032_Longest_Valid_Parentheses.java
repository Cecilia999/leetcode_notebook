//DP
//用一个stack来存index：
//  如果是个'('则把它的index存进stack
//  如果是个')'&top of stack是个'('，则pop'('
//  否则，吧')'的index push到stack里
//  最终stack中会剩下不match的所有parentheses的index
//  而这些index之间则是valid parentheses
//  找出index差最大的那个

class Solution {
  public int longestValidParentheses(String s) {
      int res = 0;
      Stack<Integer> stack = new Stack<Integer>();
      
      for(int i=0; i<s.length(); i++){
          
          //'('
          if(s.charAt(i) == '('){
              stack.push(i);
          }
          //')'
          else{
              if(stack.empty()) stack.push(i);
              else{
                  if(s.charAt(stack.peek()) == '(')
                      stack.pop();
                  else
                      stack.push(i);
              }
          }
      }
      
      if(stack.empty()) res=s.length();
      else{
          int high=s.length(), low=0;
          while(!stack.empty()){
              low = stack.pop();
              res = Math.max(res, high-low-1);
              high = low;
          }
          //这一步很重要！！
          //从length到每一个stack的index的长度一直到0，每一段都要对比
          res = Math.max(high-0, res);  
      }
      return res;        
  }
}