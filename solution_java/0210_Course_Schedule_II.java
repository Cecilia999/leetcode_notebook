// 题目大意
// 同207， 但是要输出topological sort的顺序

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] course : prerequisites){
            int ready = course[0];
            int pre = course[1];
            
            indegree[ready]++;
            adj.get(pre).add(ready);
        }
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        
        int visited = 0;
        while(!queue.isEmpty()){
            int pre = queue.poll();
            order[visited++] = pre;
            numCourses--;
            
            for(int cur : adj.get(pre)){
                indegree[cur]--;
                if(indegree[cur] == 0)
                    queue.offer(cur);
            }
        }
        
        return numCourses == 0? order : new int[0];
    }
}