# 159. Longest Substring with At Most Two Distinct Characters

## problem

Given a string s, return the length of the longest substring that contains at most two distinct characters.

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.

Constraints:

1 <= s.length <= 10^5
s consists of English letters.

## solution

same as 340, 992. use sliding window + hashmap

## code

```java
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] letters = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int k=2, start=0, max=0;

        for(int i=0; i<letters.length; i++){
            if(map.getOrDefault(letters[i], 0)==0)
                k--;

            map.put(letters[i], map.getOrDefault(letters[i], 0)+1);

            while(k<0){
                map.put(letters[start], map.get(letters[start])-1);
                if(map.get(letters[start])==0)
                    k++;
                start++;
            }

            max = Math.max(max, i-start+1);
        }

        return max;
    }
}
```
