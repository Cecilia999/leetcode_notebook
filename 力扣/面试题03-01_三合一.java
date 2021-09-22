// 题目大意
// 三合一。描述如何只用一个数组来实现三个栈。
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
// 构造函数会传入一个stackSize参数，代表每个栈的大小。

// 示例1:
//  输入：
// ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
// [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
//  输出：
// [null, null, null, 1, -1, -1, true]
// 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。

class TripleInOne {
    //用一维数组，需要manage index position for each stack
    int N = 3;
    int[] stackData;
    int[] index;
    int size;

    public TripleInOne(int stackSize) {
        size = stackSize;
        stackData = new int[stackSize * N];
        index = new int[N];
        for(int i=0; i<index.length; i++){
            index[i] = i*size;
        }
    }
    
    public void push(int stackNum, int value) {
        //要判断当前stack有没有满
        int pos = index[stackNum];
        if(pos < (stackNum+1)*size){
            stackData[pos] = value;
            index[stackNum]++;
        }
        
    }
    
    public int pop(int stackNum) {
        //要判断当前stack是不是空的
        int pos = index[stackNum];
        if(pos > stackNum*size){
            index[stackNum]--;
            return stackData[pos-1];
        }
        return -1;
    }
    
    public int peek(int stackNum) {
        int pos = index[stackNum];
        if(pos > stackNum*size){
            return stackData[pos-1];
        }
        return -1;
    }
    
    public boolean isEmpty(int stackNum) {
        return index[stackNum] == stackNum*size;
    }
}
