// 题目大意
// 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
// 注意:
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

// 输入: [ [1,2], [2,3], [3,4], [1,3] ]
// 输出: 1
// 解释: 移除 [1,3] 后，剩下的区间没有重叠。

// 解题思路
// 这题和56的思路差不多
// 先根据右区间从小到大排序，end=intervals[0].end
// 从intervals[1]开始遍历intervals，如果左区间>=end，说没没有重合:
//     count++;
//     end = intervals[i][1];
// 最后return intervals.length-count,即有重合的数量

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1) return 0;
        
        //sort intervals by higher bounds
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] interval1, int[] interval2){
                return interval1[1]-interval2[1];
            }
        });
        
        int count = 1;
        int end = intervals[0][1];
        
        for(int i=1; i<intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            if(L>=end){
                count++;
                end = R;
            }
        }
        
        return intervals.length-count;
    }
}