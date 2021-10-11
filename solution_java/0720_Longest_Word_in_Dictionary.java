// 题目大意
// 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
// 若无答案，则返回空字符串。

// 示例 1：

// 输入：
// words = ["w","wo","wor","worl", "world"]
// 输出："world"
// 解释： 
// 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。

class Solution {
    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        public String word;
        
        public TrieNode(){
        
        }
    }
    
    class Trie{
        public TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        
        public void insert(String word){
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(cur.children[c-'a']==null){
                   cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            
            cur.isWord = true;
            cur.word = word;
        }
        
        public String findLongest(){
            Queue<TrieNode> queue = new LinkedList<>();
            queue.offer(root);
            
            String res = "";
            
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0; i<size; i++){
                    TrieNode node = queue.poll();
                    //因为要return按照lexicographically的前面的word
                    //所以从z开始往前查找
                    for(char c='z'; c>='a'; c--){
                        if(node.children[c-'a']!=null && node.children[c-'a'].isWord){
                            res = node.children[c-'a'].word;
                            queue.offer(node.children[c-'a']);
                        }
                    }
                }
            }
            
            return res;
        }
    }
    
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(int i=0; i<words.length; i++){
            trie.insert(words[i]);
        }
        
        return trie.findLongest();
    }
}