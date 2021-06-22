# String

1. reverse string

- [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/):  
  [java](/solution_java/0151_Reverse_Words_in_a_String.java)

2. hash map

- [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/):
  [java](/solution_java/0387_First_Unique_Character_in_a_String.java)

### sliding window 滑动窗口

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
