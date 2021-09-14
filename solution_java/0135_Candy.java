// 题目大意
// 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
// 你需要按照以下要求，帮助老师给这些孩子分发糖果：
// 每个孩子至少分配到 1 个糖果。
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
// 那么这样下来，老师至少需要准备多少颗糖果呢？

// 示例 1：
// 输入：[1,0,2]
// 输出：5
// 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。

// 示例 2：
// 输入：[1,2,2]
// 输出：4
// 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        //左规则，如果左边孩子评分小于右边的孩子，右边的孩子比左边的孩子多一个candy
        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1])
                left[i] = left[i-1] + 1;
        }
        
        //candys初始化，因为下面的比较没有right[ratings.length-1]
        int candys = left[ratings.length-1];
        
        //右规则，如果右边孩子的评分小于左边的孩子，左边的孩子比右边的孩子多一个candy
        //取左右的最大值！！！！
        
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1])
                right[i] = right[i+1] + 1;
            candys += Math.max(left[i], right[i]);  //同时满足左规则和右规则
        }
        
        return candys;
    }
}