# String

## 1. 常见题型

1. reverse string

- [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/):  
  [java](/solution_java/0151_Reverse_Words_in_a_String.java)

2. hash map/table vs Queue/Deque

- [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/):
  [java](/solution_java/0387_First_Unique_Character_in_a_String.java)
- [字符流中第一个不重复的字符](https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&&tqId=11207&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):
  [java](/牛客网/JZ54_字符流中第一个不重复的字符.java)
- [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/):
  [java](/solution_java/0049_Group_Anagrams.java)
- [819. Most Common Word](https://leetcode.com/problems/most-common-word/):
  [java](/solution_java/0819_Most_Common_Word.java)

3. String.IndexOf()

- [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/):
  [java](/solution_java/0014_Longest_Common_Prefix.java)

4. **palindrome - 中心拓展**

- [647. Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/):
  [java](/solution_java/0647_Palindromic_Substrings.java)
- [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/):
  [java](/solution_java/0005_Longest_Palindromic_Substring.java)

5. int to string

- [273. Integer to English Words](https://leetcode.com/problems/integer-to-english-words/):
  [java](/solution_java/0273_Integer_to_English_Words.java)

6. String.split()

- [165. Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/):
  [java](/solution_java/0165_Compare_Version_Numbers.java)

## 2. sliding window 滑动窗口

滑动窗口的基本思路：

1. Use two pointers: start and end to represent a window.
2. Move end to find a valid window.
3. When a valid window is found, move start to find a smaller window.

滑动窗口的基本模版：

```
int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){

                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again

                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }

            /* update d here if finding maximum*/
        }
        return d;
  }
```

- [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/):
  [java](/solution_java/0003_Longest_Substring_Without_Repeating_Characters.java)
- [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/):
  [java](/solution_java/0076_Minimum_Window_Substring.java)

## 2.1 sliding window + hashmap

- [30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/):
  [java](/solution_java/0030_Substring_with_Concatenation_of_All_Words.md)
