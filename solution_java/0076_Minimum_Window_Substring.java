// 题目 #
// Given a string S and a string T, 
// find the minimum window in S which will contain all the characters in T in complexity O(n).

// Example:

// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"

// Note:

// If there is no such window in S that covers all characters in T, return the empty string “”.
// If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

// 题目大意 #
// 给定一个源字符串 s，再给一个字符串 T，要求在源字符串中找到一个窗口，这个窗口包含由字符串各种排列组合组成的，
// 窗口中可以包含 T 中没有的字符，如果存在多个，在结果中输出最小的窗口，如果找不到这样的窗口，输出空字符串。

// 解题思路 #
// 用滑动窗口 + map
// 右指针扩张到找到下一个valid window，然后用左指针缩小窗口，更新最小窗口起始点+窗口长度
// 先用map来计算string t中每个character的数量 + counter保证string t的总长度

// 每在string s里找到一个 string t中的character： counter--
// 且map中该character的数量-- （可以为负数）

// counter==0的时候，缩小左边界，寻找新的起始点
// 当前起始点在map中的数量>0的时候 counter++
// map[start] == 0 代表正好在string s中找到了string t中有的 character start的数量
// map[start] > 0 当前窗口该character的数量少了
// map[start] < 0 当前窗口该character的数量多了

//int[]的performance比hashmap高  
//int [] map = new int[128];   一共有128个ascii characters
//如果用hashmap的话, 必须先把所有character都加入到map, 否则map.get()会return nullpointer error，可以先算出string s的每个character的数量存入map

class Solution {
  public String minWindow(String s, String t) {
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      int counter = t.length();
      
      //java for each does not apply to string, you need to convert string to a char array
      for(char c : s.toCharArray()){
          //initialize c in map and make it value to 0
          map.put(c, 0);
      }
      for(char c : t.toCharArray()){
          //if s does not contain t, return empty
          if(map.containsKey(c))
              map.put(c, map.get(c)+1);
          else
              return "";
      }
      
      int start=0, end=0, minStart=0, minLen=Integer.MAX_VALUE;
      
      while(end<s.length()){
          char cEnd = s.charAt(end);
          
          // If char in t exists in s, decrease counter and map.get(cEnd)
          if(map.get(cEnd)>0){
              counter--;
          }       
          map.put(cEnd, map.get(cEnd)-1);
          
          //expand sliding window
          end++;
          
          //when current window is a valid window, increase start to find the smallest window
          while(counter==0){
              //if current window size is the smallest, update minStart and minLen
              if(minLen > end - start){
                  minStart = start;
                  minLen = end - start;
              }
             
              char cStart = s.charAt(start);
              map.put(cStart, map.get(cStart)+1);

              //只有string t中的character才会map.get(cStart)>0
              if(map.get(cStart)>0)
                  counter++;
              
              start++;
          }
      }
      
      return minLen==Integer.MAX_VALUE? "" : s.substring(minStart, minStart + minLen);
  }
}