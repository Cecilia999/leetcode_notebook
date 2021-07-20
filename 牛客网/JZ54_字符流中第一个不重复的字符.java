// 题目大意
// 请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
// 当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是"l"。
// 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
// string caseout = "";
// 1.读入测试用例字符串casein
// 2.如果对应语言有Init()函数的话，执行Init() 函数
// 3.循环遍历字符串里的每一个字符ch {
// Insert(ch);
// caseout += FirstAppearingOnce()
// }
// 2. 输出caseout，进行比较。
// 返回值描述：
// 如果当前字符流没有存在出现一次的字符，返回#字符。

// 示例1
// 输入：
// "google"
// 返回值：
// "ggg#ll"

//解题思路
//一个int array用来储存字符出现的次数，因为ascii最多只有128个
//一个deque用来储存只出现一次的字符

import java.util.*;

public class Solution {
    private int[] count = new int[128];
    private Deque<Character> queue = new LinkedList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        // queue.remove(ch); 这样会报越界异常。
        if(count[ch]==0){
            queue.addLast(ch);
        }
        else{
            queue.remove(ch);
        }
        count[ch]++;

    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(queue.isEmpty()){
            return '#';
        }
        else{
            return queue.getFirst();
        }
    }
}