class MaxQueue {
    Deque<Integer> queue = new LinkedList<Integer>();
    Deque<Integer> maxQueue = new LinkedList<Integer>();

    public int max_value() {
        if(maxQueue.isEmpty())
            return -1;
        return maxQueue.peekFirst();
    }
    
    public void push_back(int value) {
        queue.offerLast(value);
        
        while(!maxQueue.isEmpty() && value>maxQueue.peekLast()){
            maxQueue.pollLast();     
        }
              
        maxQueue.offerLast(value);      
    }
    
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        
        if(maxQueue.peekFirst().equals(queue.peekFirst()))  //对象只能用.equals()!!!!!!!!
            maxQueue.pollFirst();
        
        //或者用int ans = queue.pollFirst();
        //if(ans == maxQueue.peekFirst())
        return queue.pollFirst();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */