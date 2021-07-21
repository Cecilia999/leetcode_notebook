import java.util.*;

public class Solution {
    private PriorityQueue<Integer> large = new PriorityQueue<Integer>(Collections.reverseOrder());
    private PriorityQueue<Integer> small = new PriorityQueue<Integer>();
    private boolean even = true;
    
    public void Insert(Integer num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public Double GetMedian() {
        if(even){
            return (large.peek() + small.peek()) / 2.0;

        } else{
            return new Double(small.peek());
        }
    }


}