// 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
// 示例1:
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
//  输出：true

// 示例2:
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
//  输出 true

// 提示：
// 节点数量n在[0, 1e5]范围内。
// 节点编号大于等于 0 小于 n。
// 图中可能存在自环和平行边。


//正向dfs超时，用逆向dfs，先从target开始搜！！！
class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<int[]> curPath = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            if(graph[i][1]==target)
                curPath.add(graph[i]);
        }

        return dfs(curPath, graph, start);
    }

    private boolean dfs(List<int[]> curPath, int[][] graph, int start){
        if(curPath.size()==0)
            return false;

        List<int[]> nextPath = new ArrayList<>();
        for(int[] path : curPath){
            if(path[0]==start){
                nextPath.add(path);
                return true;
            }

            for(int i=0; i<graph.length; i++){
                if(graph[i][1]==path[0]){
                    nextPath.add(graph[i]);
                }                
            }
        }

        return dfs(nextPath, graph, start);       
    }
}