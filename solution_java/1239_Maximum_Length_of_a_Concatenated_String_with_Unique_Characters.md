# 1239. Maximum Length of a Concatenated String with Unique Characters

## PD

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:

- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
  Maximum length is 4.
  Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.

## solution

1. Initial the result res to include the case of empty string "".

   - res include all possible combinations we find during we iterate the input.

2. Itearte the the input strings, but skip the word that have duplicate characters.
   The examples is kind of misleading,
   but the input string can have duplicate characters,
   no need to considerate these strings.

3. For each string in input arr, concate it with every string in res
   if it is unique, add to the templist.
   res.addAll(templist)

4. return the max length of all the combination inside res

## code

```java
class Solution {
    //check if the input string has repeat character first
    //backtracking each char concate with the list of str checked for uniqueness already
    public boolean isUnique(String str){
        boolean[] visited = new boolean[26];

        for(char c : str.toCharArray()){
            if(visited[c-'a'])
                return false;

            visited[c-'a'] = true;
        }

        return true;
    }

    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        res.add("");

        for(String str : arr){
            List<String> list = new ArrayList<>();

            if(!isUnique(str))
                continue;

            for(String s : res){
                String temp = str + s;
                if(isUnique(temp)){
                    list.add(temp);
                }
            }
            res.addAll(list);
        }

        int max = 0;
        for(String str : res){
            max = Math.max(str.length(), max);
        }
        return max;
    }
}
```
