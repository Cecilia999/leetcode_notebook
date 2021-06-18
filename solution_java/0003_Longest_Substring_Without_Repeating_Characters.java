//思路：hashmap存character的值和位置
//two pointer，一个for loop
//用右指针遍历，左指针保证不重复
//If the character is already in the hashmap, then move the left pointer to the right of the same character last found.
//把left pointer移到重复的character的右边

class Solution {
  public int lengthOfLongestSubstring(String s) {
      int n = s.length(), max=1;
      if(n<2) return n;
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      
     for(int slow=0, fast=0; fast<n; fast++){
          if(map.containsKey(s.charAt(fast))){
              //对比left和当前这个重复letter的上一次出现的位置的意义是
              //避免在这间包含了另一个已经重复过的letter
              
              //map.get(s.charAt(fast))+1是到上一次这个字母出现的位置的右边
              slow = Math.max(slow, map.get(s.charAt(fast))+1);
          }
          map.put(s.charAt(fast), fast);
          max = Math.max(max, fast-slow+1);                       
      }
      
      return max;
  }
}