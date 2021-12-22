# 340. Longest Substring with At Most K Distinct Characters

## problem

Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.

Constraints:

1 <= s.length <= 5 \* 10^4
0 <= k <= 50

## solution

hashmap + sliding window

## code

```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] letters = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        int start = 0, max = 0;
        for(int i=0; i<letters.length; i++){
            if(map.getOrDefault(letters[i], 0) == 0){
                k--;
            }

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
