# 269. Alien Dictionary

## problem

There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.

## solution

1. 构建图 `HashMap<Character, Set<Character>>` key->比 key 小的字母
   已知 input words is in lexicographical order, 两两对比相邻的 words 直到第一个不相等的 character

   > lexicographical order 是由第一个不相等的 character 决定的
   > 如果都相等就是由 length 决定，length 小的在前面

2. 计算 map 中每个 character 的 indegree[]，按照 indegree 从小到大排序
   - 1. int[] indegree = new int[26] 一共只有 26 个 lowercase letter
   - 2. fill indegree with -1
   - 3. find all character exist in words，set indegree[c] = 0
   - 4. int count = different characters exist in words
   - 5. find all indegree by loop map.keyset + map.get(key)
   - 6. queue + stringbuilder
   - 7. append all the characters with indegree[c] = 0 to queue
   - 8. start loop

## code

```java
class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap<>();

        //1. 构建图
        for(int i=0; i<words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            //edge case:  ["abc", "ab"]
            if (w1.length() >w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for(int j=0; j<words[i].length() && j<words[i+1].length(); j++){
                char c1 = words[i].charAt(j);
                char c2 = words[i+1].charAt(j);
                if(c1!=c2){
                    Set<Character> set = new HashSet<>();
                    if(graph.containsKey(c1)){
                        set = graph.get(c1);
                    }

                    if(!set.contains(c2)){
                        set.add(c2);
                        graph.put(c1, set);
                    }
                    break;
                }
            }
        }

        //2. calculate indegree
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        int count = 0;

        for(String word : words){
            for(char c : word.toCharArray()){
                indegree[c-'a'] = 0;
            }
        }

        for(int i=0; i<26; i++){
            if(indegree[i]==0)
                count++;
        }

        for(char ch : graph.keySet()){
            for(char c : graph.get(ch)){
                indegree[c-'a']++;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(indegree[i]==0){
                queue.offer((char)(i+'a'));
            }
        }

        while(!queue.isEmpty()){
            char cur = queue.poll();
            System.out.println(cur);
            sb.append(cur);
            count--;
            indegree[cur-'a']--;

            if(graph.containsKey(cur)){
                for(char c : graph.get(cur)){
                    indegree[c-'a']--;
                    if(indegree[c-'a']==0)
                        queue.offer(c);
                }
            }
        }

        return count==0? sb.toString():"";
    }
}
```
