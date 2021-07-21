//题目大意
// 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
// 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

//解题思路
//使用一个大顶堆和一个小顶堆
//data stream 应该按大小顺序 一半在小顶堆，一半大顶堆

//addNum时
//data stream size == even 代表之前data stream size是even
//插入数字到large
//如果该数字比large所有的数字都要小，那么该数字会在large.peek()
//poll large.peek() 并且放入small
//findMedian() return small.peek()

//addNum时
//data stream size == odd 代表之前data stream size是odd
//插入数字到small
//如果该数字比large所有的数字都要大，那么该数字会在small.peek()
//poll small.peek() 并且放入large
//findMedian() return large.peek() + small.peek() / 2.0

class MedianFinder {
    //pq.peek()返回的是第一个element 所以large应该是小顶堆，small应该是大顶堆，这样才能保证从小到大的顺序
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());
    private boolean even = true;
    
    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        } else{
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (large.peek() + small.peek()) / 2.0;
        }
        else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */