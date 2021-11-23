# 30. Substring with Concatenation of All Words

You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

Constraints:

1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.

## code

performance is not so well for both version;

1.

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null || words==null) return res;

        int n = words.length;
        int m = words[0].length();  //all the words has the same length

        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        //只用遍历到s.length() - n*m的位置就可以了
        //也可以用copy.equals(map)，对比两个hashmap
        for(int i=0; i<s.length() - n*m+1; i++){
            Map<String, Integer> copy = new HashMap<>();
            int window = n;
            int j = i;
            while(window>0){
                String str = s.substring(j, j+m);
                copy.put(str, copy.getOrDefault(str, 0)+1);
                j += m;
                window--;
            }
            if(copy.equals(map))
                res.add(i);
        }

        return res;
    }
}
```

2.

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null || words==null) return res;

        int n = words.length;
        int m = words[0].length();  //all the words has the same length

        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        //只用遍历到s.length() - n*m的位置就可以了
        //也可以用copy.equals(map)，对比两个hashmap
        for(int i=0; i<s.length() - n*m+1; i++){
            Map<String, Integer> copy = new HashMap<>(map);
            int window = n;
            int j = i;
            while(window>0){
                String str = s.substring(j, j+m);
                //s is not in map or 出现了太多次
                if(!copy.containsKey(str) || copy.get(str)<1 )
                    break;
                copy.put(str, copy.get(str)-1);
                window--;
                j += m;
            }
            if(window==0)
                res.add(i);
        }

        return res;
    }
}
```
