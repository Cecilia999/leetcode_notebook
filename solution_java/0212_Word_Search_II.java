// 题目大意
// 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

// 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
// words = ["oath","pea","eat","rain"]
// 输出：["eat","oath"]

// 解题思路
// Tire + dfs

class Solution {
    static class TrieNode{
        public TrieNode[] children = new TrieNode[26];  //constriants says words[i] consist of lowercase English letter
        public String word;
        public TrieNode(){}
    }

    public static TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode cur = root;

            for(char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        return root;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){                
                dfs(board, visited, root, res, i, j);
            }
        }

        return res;
    }

    public static void dfs(char[][] board, boolean[][] visited, TrieNode root, List<String> res, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length  )
            return;
        
        //The same letter cell may not be used more than once in a word.
        if(visited[i][j]) return;
        if(root.children[board[i][j]-'a']==null) return;  //没有children了

        root = root.children[board[i][j]-'a'];
        if(root.word!=null){
            res.add(root.word);
            root.word = null;  //remove duplicate
        }

        visited[i][j] = true;
        dfs(board, visited, root, res, i+1, j);
        dfs(board, visited, root, res, i, j+1);
        dfs(board, visited, root, res, i-1, j);
        dfs(board, visited, root, res, i, j-1);
        visited[i][j] = false;
    }
}