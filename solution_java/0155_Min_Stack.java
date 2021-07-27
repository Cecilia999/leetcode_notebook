// 题目大意 #
// 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
// 并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
// push(value):将value压入栈中
// pop():弹出栈顶元素
// top():获取栈顶元素
// min():获取栈中最小元素

// 解题思路 #
// 正常情况下，栈的push，pop操作都为O(1),
// 但是返回最小值，需要遍历整个栈，时间复杂度为O(n)，所以这里需要空间换时间的思想。
// 用两个stack，一个用于栈的正常操作，一个辅助栈minval，专门用于获取最小值
// 两个stack必须保持同一高度，即不能只有push的value<当前最小min才push最新的min value到辅助栈
// 否则pop的时候找不到下一个最小值
// push的时候判断是不是最小值，是的话加入到两个stack
// 不是最小值的话，加入上一个最小值到两个stack
// pop时同时pop两个stack

class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int val) {
        stack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }
        else{
            int lastMin = minStack.peek();
            if(val<lastMin)
                minStack.push(val);
            else
                minStack.push(lastMin);   
        }
        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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