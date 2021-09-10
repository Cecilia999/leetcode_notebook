// 题目大意
// 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。

// 例如：
// [2,3,4]，中位数是 3
// [2,3]，中位数是 (2 + 3) / 2 = 2.5
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
// 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。

// 示例：
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
// 窗口位置                      中位数
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       1
//  1 [3  -1  -3] 5  3  6  7      -1
//  1  3 [-1  -3  5] 3  6  7      -1
//  1  3  -1 [-3  5  3] 6  7       3
//  1  3  -1  -3 [5  3  6] 7       5
//  1  3  -1  -3  5 [3  6  7]      6
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。

// 提示：
// 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。

// 解题思路
// 关键求中位数的算法和295题一样
// 用大顶堆放小的那一半的数，用小顶堆放大的一半的数
// median = (maxheap.peek() + minheap.peek())/2.0

// 先把nums[i]加入size小的那一边，
// 当maxheap.size() + minheap.size() == k
// 求中位数，
// 然后remove当前窗口的第一个数

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        //maxheap装小的那一半，minheap装大的那一半
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());


        double[] medians = new double[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {
            //哪边更小就把num加到哪边，maxheap.size()-minheap.size()不会大于1
            if(maxHeap.size()<=minHeap.size()){
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.remove());
            }
            else{
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.remove());
            }

            if(i+1>=k){
                int index = i-k+1;
                if(maxHeap.size()==minHeap.size())
                    //long避免[2147483647,2147483647]的edge case
                    medians[index] = (double)((long)maxHeap.peek() + (long)minHeap.peek())/2.0;
                else
                    medians[index] = maxHeap.peek();
                
                if(!maxHeap.remove(nums[index]))
                    minHeap.remove(nums[index]);
            }
        }
        
        return medians;
    }
}