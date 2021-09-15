// 题目大意
// 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

// 示例 1：
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
// 输出：[[1,5],[6,9]]

// 示例 2：
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// 输出：[[1,2],[3,10],[12,16]]
// 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

// 示例 3：
// 输入：intervals = [], newInterval = [5,7]
// 输出：[[5,7]]

// 示例 4：
// 输入：intervals = [[1,5]], newInterval = [2,3]
// 输出：[[1,5]]

// 示例 5：
// 输入：intervals = [[1,5]], newInterval = [2,7]
// 输出：[[1,7]]
//  
// 提示：
// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= intervals[i][0] <= intervals[i][1] <= 105
// intervals 根据 intervals[i][0] 按 升序 排列
// newInterval.length == 2
// 0 <= newInterval[0] <= newInterval[1] <= 105

//解题思路
//就按照顺序，先处理左边没有重合的部分->处理中间重合的部分->再处理右边没有重合的部分
//重要的是判断是否重合的条件

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0){
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }

        int i=0;

        //没有重叠，最右小于newInterval的左边
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //有重叠, 在退出最右小于newInterval的左边的loop的基础上，最左边小于等于newInterval的右边
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        //没有重叠，所有的intervals都在newInterval的右边
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int[res.size()][]);
    }
}