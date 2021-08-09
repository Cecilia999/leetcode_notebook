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

//解题思路 queue + bfs

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //用一个queue实现bfs
        Queue<String> queue = new LinkedList<String>();
        //必须要用hashset来存wordlist，arraylist的remove和contains会超时
        HashSet<String> set = new HashSet<String>(wordList);
        
        queue.add(beginWord);
        int steps = 1;
        while(!queue.isEmpty()){    
            //必须要bfs每一层保存一次queue size，否则queue一直在增大
            int curQueueSize = queue.size();
            for(int i=0; i<curQueueSize; i++){
                String s = queue.poll();

                if(s.equals(endWord))
                    return steps;
                
                for(int j=0; j<s.length(); j++){
                    for(char ch='a'; ch<='z'; ch++){
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(j, ch);
                        String word = sb.toString();
                        
                        if(set.contains(word)){
                            queue.add(word);
                            set.remove(new String(word));
                        }
                    }
                }
            }
            steps++;
        }
        
        return 0;
    }
}