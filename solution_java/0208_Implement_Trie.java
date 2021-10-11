// 题目大意
// Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

// 请你实现 Trie 类：

// Trie() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

// 解题思路
// 用TireNode, 可以用数组或者hashmap

class TrieNode{
    public char val; //可以不需要val
    public boolean isWord;  //end flag
    public TrieNode[] children = new TrieNode[26]; //在208题里只有小写字母，所以最多只有26个child TrieNode
    public TrieNode(){}
    public TrieNode(char c){
        TrieNode node = new TrieNode();  //call the default constructor
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c-'a']==null){
                cur.children[c-'a'] =  new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c-'a']==null){
                return false;
            }
            cur = cur.children[c-'a'];
        }

        return cur.isWord; //需要是个单词
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c-'a']==null){
                return false;
            }
            cur = cur.children[c-'a'];
        }

        return true;  //只需要存在前缀
    }
}
