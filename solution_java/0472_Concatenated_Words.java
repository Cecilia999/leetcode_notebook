// 题目大意
// 给定一个 不含重复 单词的字符串数组 words ，编写一个程序，返回 words 中的所有 连接词 。
// 连接词 的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。

// 示例 1：
// 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
// 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
// 解释："catsdogcats"由"cats", "dog" 和 "cats"组成; 
//      "dogcatsdog"由"dog", "cats"和"dog"组成; 
//      "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
// 示例 2：
// 输入：words = ["cat","dog","catdog"]
// 输出：["catdog"]

//解题思路
//类似139. word break用两个pointer
//iterate input words
//check if words[i] can be formed by previous words[0:i]
//should sort words[] first since 长的单词可能是由短的单词组成的

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWord = new HashSet<>();
        
        Arrays.sort(words, (s1, s2)->{
            return s1.length()-s2.length();
        });
        
        
        for(int i=0; i<words.length; i++){
            if(canForm(words[i], preWord)){
                res.add(words[i]);
            }
            preWord.add(words[i]);
        }
        
        return res;
    }
    
    //logic same as 136. word break
    public boolean canForm(String s, Set<String> preWord){
        //if preWord is empty
        if(preWord.isEmpty()) return false;
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int r=1; r<=s.length(); r++){
            for(int l=0; l<r; l++){
                if (!dp[l]) continue;      //这个条件runtime快了一半
                if(preWord.contains(s.substring(l, r))){
                    dp[r] = true;
                    break;
                }                    
            }
        }
        
        return dp[s.length()];
    }
}