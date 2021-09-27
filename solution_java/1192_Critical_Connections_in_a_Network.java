// 题目大意
// 力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
// 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
// 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
// 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
// 请你以任意顺序返回该集群内的所有 「关键连接」。

// 示例 1：
// 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// 输出：[[1,3]]
// 解释：[[3,1]] 也是正确的。
//  
// 提示：
// 1 <= n <= 10^5
// n-1 <= connections.length <= 10^5
// connections[i][0] != connections[i][1]
// 不存在重复的连接

// 解题思路
// 1. An edge is a critical connection, if and only if it is not in a cycle.
// 2. how to find a critical connection:
//     dfs the graph, give each visited node an incremental id. 
//     Once find a node with id less than its parent -->> means there is a cycle.

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 构建一个graph，存放每个节点的相邻节点有哪些
        //can use array or hashmap
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        //fill the graph array with the edges in connections
        for(List<Integer> eachConnection : connections){
            graph[eachConnection.get(0)].add(eachConnection.get(1));
            graph[eachConnection.get(1)].add(eachConnection.get(0));
        }
        
        //创建一个数组用来记录每个点的id
        int[] id = new int[n];
        HashSet<List<Integer>> connectionSet = new HashSet<>(connections);
        
        Arrays.fill(id, -2);
        dfs(id, graph, 0, 0, connectionSet);
        return new ArrayList<>(connectionSet);
    }
    
    private int dfs(int[] id, List<Integer>[] graph, int node, int depth, HashSet<List<Integer>> connectionSet){
        if(id[node]>=0){
            return id[node];
        }
        
        id[node] = depth;
        int minDepthFound = depth;
        
        //对每个neighbor dfs        
        for(int neighbor : graph[node]){
            //skip parents
            if(id[neighbor]==depth-1){
                continue;
            }
            
            int minDepth = dfs(id, graph, neighbor, depth+1, connectionSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            
            //只要发现一个minDepth<depth 说明存在cycle
            if(minDepth<=depth){
                connectionSet.remove(Arrays.asList(node, neighbor));
                connectionSet.remove(Arrays.asList(neighbor, node));
            }
        }
        
        return minDepthFound;
    }
}