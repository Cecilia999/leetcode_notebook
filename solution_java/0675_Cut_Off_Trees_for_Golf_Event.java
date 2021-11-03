// 题目大意
// 你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：

// 0 表示障碍，无法触碰
// 1 表示地面，可以行走
// 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。

// 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。

// 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。

// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。

// 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
// 输出：6
// 解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。

// 解题思路
// bfs+PriorityQueue

class Solution {
    public int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        //1. cut tree in order from shortest to tallest
        if(forest == null || forest.size() == 0){
            return 0;
        }
        
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] nums1, int[] nums2){
                return nums1[2]-nums2[2];
            }
        });
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(forest.get(i).get(j) > 1)
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        
        int[] start = new int[2];
        int stepSum = 0;
        
        //2. bfs calculate the shorest path
        while(!pq.isEmpty()){
            int[] next = pq.poll();
            int step = minStep(forest, start, next, m, n);
            if(step<0) return -1;
            
            stepSum += step;
            
            start[0] = next[0];
            start[1] = next[1];
        }
        
        return stepSum;
    }
    
    public int minStep(List<List<Integer>> forest, int[] start, int[] next, int m, int n){
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] cur = queue.poll();
                if(cur[0]==next[0] && cur[1]==next[1]) return step;

                for(int[] dir : dirs){
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];

                    if(row<0 || row>=m || col<0 || col>=n || forest.get(row).get(col)==0 || visited[row][col]) continue;

                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
            step++;
        }
        
        return -1;
    }
}