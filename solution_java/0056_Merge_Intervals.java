// 题目大意
// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
// 示例
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

// 解题思路
// 1. 需要添加list到list，用arraylist，在转化为int[][] 2d array
// 2. 将列表中的区间按照左端点升序排序
// 3. 将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
//     - 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，
//       我们可以直接将这个区间加入数组 merged 的末尾；
//     - 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，
//       将其置为二者的较大值。

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        
        //sort interval by lower bounds
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] interval1, int[] interval2){
                return interval1[0]-interval2[0];      
            }
        });
        
        //merge interval by higher bounds
        for(int i=0;  i<intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            //index out of bounds when res.size()==0
            //int[] cur = res.get(res.size()-1); 
            
            //if res is empty or the lower bound is larger than the current interval
            //add the new interval to the res
            if(res.size()==0 || L>res.get(res.size()-1)[1])
                res.add(intervals[i]);
            else{
                //edit arraylist
                res.get(res.size()-1)[1] = Math.max(R, res.get(res.size()-1)[1]);
            }
            
        }
        
        return res.toArray(new int[res.size()][]);
    }
}