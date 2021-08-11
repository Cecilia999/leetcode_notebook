// 题目大意
// 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：

// 序列中第一个单词是 beginWord 。
// 序列中最后一个单词是 endWord 。
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典 wordList 中的单词。
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。

// 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// 输出：5
// 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。

// 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// 输出：0
// 解释：endWord "cog" 不在字典中，所以无法进行转换。

//解题思路 hashset + 双向bfs

//双向bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将wordList放入哈希表里, contains & remove都是o(1)
        HashSet<String> wordSet = new HashSet<String>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        if(wordSet.contains(beginWord)) wordSet.remove(beginWord);
        
        //用beginset & endset实现双向bfs
        HashSet<String> beginset = new HashSet<String>();
        HashSet<String> endset = new HashSet<String>();
        
        beginset.add(beginWord);
        endset.add(endWord);
        int step = 1;
        
        while( !beginset.isEmpty() && !endset.isEmpty() ){
            //let beginset be the smaller set
            if(beginset.size() > endset.size()){
                HashSet<String> temp = beginset;
                beginset = endset;
                endset = temp;
            }
            
            HashSet<String> nextLevelVisited = new HashSet<String>(); 
            
            for(String word : beginset){
                for(int i=0; i<word.length(); i++){
                    for(char c='a'; c<='z'; c++){
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, c);
                        String s = sb.toString();
                        
                        if(endset.contains(s)){
                            return step+1;
                        }
                        
                        //check if s is in wordlist
                        if(wordSet.contains(s)){
                            nextLevelVisited.add(s);
                            wordSet.remove(new String(s));
                        }
                    }
                }
            }

            beginset = nextLevelVisited;
            step++;
        }
        
        return 0;
    }
}

