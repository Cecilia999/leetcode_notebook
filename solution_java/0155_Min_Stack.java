// 题目大意 #
// 这道题是一个数据结构实现题。要求实现一个栈的类，实现 push()、pop()、top()、getMin()。

//解题思路 #
//implement my own stack using a private class Node
//Node 是个linked list


class MinStack {
    
    private class Node{
        int val;
        int min;
        Node next;
        
        private Node(int val, int min){
            this.val=val;
            this.min=min;
            this.next = null;
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    private Node head;
    
    public void push(int val) {
        if(head==null){
            head = new Node(val, val);
        }
        else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */