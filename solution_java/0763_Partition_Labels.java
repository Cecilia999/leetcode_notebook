// 题目大意
// 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
// 返回一个表示每个字符串片段的长度的列表。

// 示例：
// 输入：S = "ababcbacadefegdehijhklij"
// 输出：[9,7,8]
// 解释：
// 划分结果为 "ababcbaca", "defegde", "hijhklij"。
// 每个字母最多出现在一个片段中。
// 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//  
// 提示：
// S的长度在[1, 500]之间。
// S只包含小写字母 'a' 到 'z' 。

// 解题思路
// 1. 先遍历一遍s记录每个字母最后一次出现的位置last[i]
// 2. 再遍历一次s，两个指针，用start记录当前片段的起点，end寻找当前片段的终点
//     - 用end表示当前字母最后一次出现的位置vs当前片段结束位置的最大值
//     - 如果 当前位置i==end，把start到end的长度加入partition，更新start的位置

class Solution {
    public List<Integer> partitionLabels(String s) {
        //1.找到每个字母最后出现的位置
        int[] last = new int[26];
        for(int i=0; i<s.length(); i++){
            last[s.charAt(i)-'a'] = i; 
        }
        
        //2. 两个指针start，end. end为遍历的当前字母的最后出现位置的max
        //当i==end，找到一个片段
        int start=0, end=0;
        List<Integer> partition = new ArrayList<Integer>();
        
        for(int i=0; i<s.length(); i++){
            end = Math.max(end, last[s.charAt(i)-'a']);    //!!保证找到最多的partition同时维持最后位置
            if(i==end){
                partition.add(end-start+1);
                start = end+1;
            }
        }
        
        return partition;
    }
}