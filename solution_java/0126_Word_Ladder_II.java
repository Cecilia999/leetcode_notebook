//这个答案只能过22/32个用例

class Solution {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        if(!wordSet.contains(endWord)) return res;
        if(wordSet.contains(beginWord)) wordSet.remove(beginWord);
        //记录单词是从哪些单词扩展来的
        Map<String, ArrayList<String>> nodeNeighbors = new HashMap<>();

        //BFS to find the shortest path as well as find all the possible path
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean findEnd = false;

        while(!queue.isEmpty()){
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                String curWord = queue.poll();
                if(!nodeNeighbors.containsKey(curWord))
                    nodeNeighbors.put(curWord, new ArrayList<String>());

                //把每个位置的每个字母都尝试一边
                for (int j = 0; j < curWord.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        StringBuilder sb = new StringBuilder(curWord);
                        sb.setCharAt(j, k);
                        String newWord = sb.toString();
                                                
                        //if newWord is in wordSet
                        if(wordSet.contains(newWord)){
                            nodeNeighbors.get(curWord).add(newWord);
                            if(endWord.equals(newWord)){
                                findEnd = true;             
                            }
                            else{
                                wordSet.remove(newWord);  //已经visit过的不再重复visit
                                queue.offer(newWord);
                            }
                            
                        }
                    }
                }
            }

            if(findEnd)
                break;
        }

        //DFS + backtrack to output all the shortest path
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(beginWord, endWord, nodeNeighbors, path, res);
        return res;
    }

    private static void dfs(String curWord, String endWord, Map<String, ArrayList<String>> nodeNeighbors, List<String> path, List<List<String>> res){
        //当curWord==endWord时，当前路径到底了
        if(endWord.equals(curWord)){
            res.add(new ArrayList<String>(path));
            return;
        }        
        else{
            if(nodeNeighbors.containsKey(curWord)){
                for(String nextWord : nodeNeighbors.get(curWord)){
                    path.add(nextWord);
                    dfs(nextWord, endWord, nodeNeighbors, path, res);
                    path.remove(path.size()-1);
                }   
            }                     
        }
    }
}
