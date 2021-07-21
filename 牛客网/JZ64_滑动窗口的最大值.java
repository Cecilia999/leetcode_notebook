// 描述
// 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。

// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
// 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
// {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
// {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

// 窗口大于数组长度的时候，返回空
// 示例1
// 输入：
// [2,3,4,2,6,2,5,1],3
// 返回值：
// [4,4,6,6,6,5]


import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size>nums.length || size==0)
            return res;
        
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0; i<nums.length; i++){
            //从头部把deque中不在当前窗口范围的数字拿走
            while(!dq.isEmpty() && dq.peekFirst()<i-size+1){
                dq.pollFirst();
            }
            
            //从尾部把deque中值小于nums[i]的数字拿走
            //所以deque中没有被删掉的都是在窗口范围内且比当前nums[i]更大的数字
            //所以取最大值应该从头取
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            
            //按滑动窗口的顺序加入双端队列，即从尾部加入
            dq.offerLast(i);
            if(i-size+1>=0)
                res.add(nums[dq.peekFirst()]); 
        }
        
        return res;
    }
}