// 题目大意
// 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
// 请你以字符串形式返回这个最小的数字。

// 示例 1 ：
// 输入：num = "1432219", k = 3
// 输出："1219"
// 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。

// 示例 2 ：
// 输入：num = "10200", k = 1
// 输出："200"
// 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。

// 示例 3 ：
// 输入：num = "10", k = 2
// 输出："0"
// 解释：从原数字移除所有的数字，剩余为空就是 0 。
//  
// 提示：
// 1 <= k <= num.length <= 105
// num 仅由若干位数字（0 - 9）组成
// 除了 0 本身之外，num 不含任何前导零

// 解题思路
// 贪心+栈

// 对于两个相同长度的数字序列，最左边不同的数字决定了这两个数字的大小，
// 例如，对于 A = 1axxx，B = 1bxxx，如果 a > b 则 A > B。


class Solution {
    public String removeKdigits(String num, int k) {
        //贪心+栈
        Deque<Character> deque = new LinkedList<Character>();
        
        for(char c : num.toCharArray()){
            //当前元素比左边的元素小的时候，remove左边的元素
            while(k>0 && !deque.isEmpty() && c<deque.peekLast()){
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        
        //处理k>0的情况
        while(k>0){
            deque.removeLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        while(!deque.isEmpty()){
            //remove leading zeros
            if(deque.peekFirst()!='0')
                leadingZero = false;
            if(leadingZero){
                deque.removeFirst();
                continue;
            }
            
            sb.append(deque.removeFirst());
        }
        
        return sb.length()==0? "0" : sb.toString();
    }
}