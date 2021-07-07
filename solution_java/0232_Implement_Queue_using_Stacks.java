// 题目大意 #
// 题目要求用两个栈实现一个队列的基本操作：push(x)、pop()、peek()、empty()。

// 232题是implement a lock free queue using two stack的实现，一个stack负责读，一个stack负责写
//push(): 把值放入write stack
//pop()和peek(): 需要先检查read stack是否为空，是的话把write stack里的所有的值都pop且push到read stack
//这一步使得顺序就对了

class MyQueue {
   
    Stack<Integer> write = new Stack<Integer>();
    Stack<Integer> read = new Stack<Integer>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        write.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return read.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(read.empty()){
            while(!write.empty())
                read.push(write.pop());
        }
        return read.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return write.empty() && read.empty();
    }
}
