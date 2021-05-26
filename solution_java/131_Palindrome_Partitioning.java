//思路：backtrack
//两个指针，一个start，一个遍历从start到s.length()的i
//如果start到i是回文，加入templist，更新start=i+1，遍历这一分枝

class Solution {
  public List<List<String>> partition(String s) {
      List<List<String>> list = new ArrayList<List<String>>();
      backtrackPalaindrome(list, new ArrayList<String>(), s, 0);
      return list;
  }
  
  private void backtrackPalaindrome (List<List<String>> list, ArrayList<String> templist, String s, int start){
      if(start==s.length())
          list.add(new ArrayList<>(templist));
      for(int i=start; i<s.length(); i++){
          if(isPalindrome(s, start, i)){
              templist.add(s.substring(start,i+1));       //这个条件非常重要！！！
              backtrackPalaindrome(list, templist, s, i+1);
              templist.remove(templist.size()-1);
          }
      }
  }
  
  private boolean isPalindrome(String s, int start, int end){
      while(start<end){
          if(s.charAt(start)!=s.charAt(end))
              return false;
          start++;
          end--;
      }
      return true;
  }
}