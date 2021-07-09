// 题目大意 #
// 给 2 个数组，一个数组里面代表的是 push 的顺序，另一个数组里面代表的是 pop 的顺序。问按照这样的顺序操作以后，最终能否把栈清空？

// 解题思路 #
// 按照 push 数组的顺序先把压栈，然后再依次在 pop 里面找栈顶元素，找到了就 pop，直到遍历完 pop 数组，最终如果遍历完了 pop 数组，就代表清空了整个栈了。

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(int num : pushed){
            stack.add(num);
            
            while(!stack.empty() && stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        
        return stack.empty();
    }
}