题目大意 #
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。返回滑动窗口最大值。

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 //双端队列deque
 class Solution {
    public int[] maxSlidingWindow(int[] nums, int size) {
        int[] res = new int[nums.length-size+1];
        if(size>nums.length || size==0 ) return res;
        
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
                res[i-size+1] = nums[dq.peekFirst()]; 
        }
        
        return res;
    }
}

//暴力解法超时
//两层loop，第一层从 0～(nums.length - window_size)
//第二层loop从 0～window_size
//用max保留当前窗口的最大值
//每次更新窗口，初始化max为最小值
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k>nums.length) return null;
        
        int[] res = new int[nums.length-k+1];
        int max;
        
        for(int i=0; i<nums.length-k+1; i++){
            max = Integer.MIN_VALUE;
            for(int j=0; j<k; j++){
                if(nums[i+j]>max){
                    max = nums[i+j];
                }
            }
            res[i] = max;
        }
        
        return res;
    }
}

//Priority Queue在leetcode超时
//思路是先把窗口内的数字加入pq
//peek出第一个最大值
//然后每次向右移动窗口将nums[i] 加入pq，num[i-size+1]从pq中取出
//之后重新去当前窗口最大值pq.peek()
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if(k>nums.length || k==0 ) return res;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int index = 0;
        
        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
        }
        res[index++] = pq.peek();
        pq.remove(nums[0]);
        
        for(int i=k; i<nums.length; i++){
            pq.offer(nums[i]);
            res[index++] = pq.peek();
            pq.remove(nums[i-k+1]);
        }
        
        return res;
    }
}