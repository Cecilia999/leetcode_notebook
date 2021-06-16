//遇到空格就跳过，遇到单词就让滑窗扩大，直到空格
//使用stack可以更方便的把倒序的单词变成正顺序，一旦提到倒序，要自然而然的联想到stack
//stack push & pop is o(1)

class Solution {
  public String reverseWords(String s) {
      Stack<String> stack = new Stack<String>();
      StringBuilder res = new StringBuilder();
      
      for(int i=0; i<s.length(); i++){
          if(s.charAt(i)!=' '){
              StringBuilder sb = new StringBuilder();
               while(i<s.length() && s.charAt(i)!=' '){
                  sb.append(s.charAt(i));
                  i++;
              }
              
              stack.push(sb.toString());   
          }
      }
      
      while(!stack.isEmpty()){
          res.append(stack.pop() + " ");
      }
      res.deleteCharAt(res.length() - 1);
      
      return res.toString();
  }
}

//还有一种思路是
//1.先reverse 整个string
//2.reverse each word
//3. cleanup space