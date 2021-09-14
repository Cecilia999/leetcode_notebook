// 题目大意
// 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
// 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

// 示例 1:
// 输入: "2-1-1"
// 输出: [0, 2]
// 解释: 
// ((2-1)-1) = 0 
// (2-(1-1)) = 2

// 示例 2:
// 输入: "2*3-4*5"
// 输出: [-34, -14, -10, -10, 10]
// 解释: 
// (2*(3-(4*5))) = -34 
// ((2*3)-(4*5)) = -14 
// ((2*(3-4))*5) = -10 
// (2*((3-4)*5)) = -10 
// (((2*3)-4)*5) = 10

// 解题思路
// recursion + 分治法
// loop输入的expression，每次遇到一个operator就拆成两边，分别计算，再合并计算

class Solution {
    //可以用hashmap来保存计算结果，不用每次都重复计算
    //Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        //if(map.containsKey(input)) return map.get(input);

        char[] ch = expression.toCharArray();
        List<Integer> res = new ArrayList<Integer>();

        for(int i=0; i<ch.length; i++){
            if(ch[i]=='+' || ch[i]=='-' || ch[i]=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                for (int p1 : left) {
                    for(int p2 : right){
                        if(ch[i]=='+')
                            res.add(p1+p2);
                        if(ch[i]=='-')
                            res.add(p1-p2);
                        if(ch[i]=='*')
                            res.add(p1*p2);
                    }
                }
            }
        }

        //edge case: no operator
        if(res.size()==0){
            res.add(Integer.valueOf(expression));
        }
        
        //map.put(input, res);
        return res;
    }
}
