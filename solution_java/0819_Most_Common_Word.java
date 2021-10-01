// 题目大意
// give you a paragraph and a string[] contains banned words.
// return the most frequency word that is not in banned.
// The given paragraph is not case-sensitive, so you need to deal with uppercase/lowercase;
// but only return lowercase word.

// 解题思路
// 1. String.toLowerCase();
// 2. remove punctuation with delimiter "\\W+": means non-word character
// 3. HashMap

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String str = paragraph.toLowerCase();
        // "\\W+", non-word delimiter
        String[] words = str.split("\\W+");
        System.out.println(str);
        
        HashSet<String> banSet = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!banSet.contains(word))
                map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        int max = 0;
        String res = words[0];
        for(String word : map.keySet()){
            if(map.get(word)>max){
                res = word;
                max = map.get(word);
            }
        }
        return res;
    }
}