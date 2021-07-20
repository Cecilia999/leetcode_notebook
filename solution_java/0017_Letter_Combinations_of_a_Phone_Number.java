// 题目大意 #
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。
// 注意 1 不对应任何字母。

// 解题思路 #
// DFS + queue(linkedlist) 递归深搜即可

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if(digits.length()==0) return res;
        
        //用个string array来保存数字到字母的映射，、
        //因为正好0—9可以对应index position
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};        
        res.add("");
        
        //第一个loop，获得每个digit对应的字母
        for(int i=0; i<digits.length(); i++){
            //拿到digit value
            int digit = digits.charAt(i)-'0';
            
            //第二个loop，获得res里的每一组letter combination
            //每个letter combination的长度应该等于i，即loop了几个digit的个数
            //用res里的string的长度判断loop什么时候结束
            //从头部将queue中的string取出来再从尾部放入
            while(res.peek().length()==i){
                String letterCom = res.remove();
                
                //第三个loop 当前digit对应的char array全部加到res里
                for(char l: dict[digit].toCharArray()){
                    res.add(letterCom+l);  //顺序不能变
                }
            }
        }
        return res;
    }
}