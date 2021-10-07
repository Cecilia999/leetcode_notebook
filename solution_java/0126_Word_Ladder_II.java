//单词接龙，要找出所有路径
//先bfs在dfs

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        
        HashMap<String, ArrayList<String>> neighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, dict, neighbors, distance);
        
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(beginWord, endWord, neighbors, distance, res, new ArrayList<String>());
        return res;
    }
    
    //BFS: find all node's distance from start to end
    public void bfs(String start, String end, HashSet<String> dict, HashMap<String, ArrayList<String>> neighbors, HashMap<String, Integer> distance){
        //先把dict的每个单词加入map
        for(String s : dict){
            neighbors.put(s, new ArrayList<String>());
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean foundEnd = false;
            for(int i=0; i<size; i++){
                String word = queue.poll();
                int wordDist = distance.get(word);
                List<String> neighborWords = getNeighbors(word, dict);

                //check each word in neighborWords
                //add neighborWords to neighbors map
                //add distance 
                //check if word==end
                for(String neighbor : neighborWords){
                    neighbors.get(word).add(neighbor);
                    
                    //没有visit过
                    if(!distance.containsKey(neighbor)){  
                        distance.put(neighbor, wordDist+1);
                        if(neighbor.equals(end))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }                        
                }
                
                if(foundEnd)
                    break;
            }
        }
    }
    
    public List<String> getNeighbors(String word, HashSet<String> dict){
        List<String> res = new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            for(char c='a'; c<='z'; c++){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                String newWord = sb.toString();

                if(dict.contains(newWord)){
                    res.add(newWord);
                }
            }
        }
        
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
