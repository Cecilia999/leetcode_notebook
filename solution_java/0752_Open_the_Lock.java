// 题目大意
// 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
// 示例 1:
// 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
// 输出：6
// 解释：
// 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
// 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
// 因为当拨动到 "0102" 时这个锁就会被锁定。
// 示例 2:
// 输入: deadends = ["8888"], target = "0009"
// 输出：1
// 解释：
// 把最后一位反向旋转一次即可 "0000" -> "0009"。
// 示例 3:
// 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
// 输出：-1
// 解释：
// 无法旋转到目标数字且不被锁定。
// 示例 4:
// 输入: deadends = ["0000"], target = "8888"
// 输出：-1

// 解题思路
// 和127题一样 双向bfs

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<String>(Arrays.asList(deadends));
        if(deadSet.contains(target) || deadSet.contains("0000")) return -1;

        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        beginSet.add("0000");
        endSet.add(target);
        int step = 0;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> temp = new HashSet<String>(beginSet);
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelVisit = new HashSet<String>();
            for(String s : beginSet){
                if(endSet.contains(s)) return step;
                if(deadSet.contains(s)) continue;
                deadSet.add(s);

                StringBuilder sb = new StringBuilder(s);
                for(int i=0; i<4; i++){
                    char originChar = s.charAt(i);                    
                    char up = (char)(originChar=='9'? '0':originChar+1);
                    char down = (char)(originChar=='0'? '9':originChar-1);
                    sb.setCharAt(i, up);
                    String s1 = sb.toString();
                    sb.setCharAt(i, down);
                    String s2 = sb.toString();
                    sb.setCharAt(i, originChar);

                    if(!deadSet.contains(s1))
                        nextLevelVisit.add(s1);
                    if(!deadSet.contains(s2))
                        nextLevelVisit.add(s2);
                }
            }
            beginSet = nextLevelVisit;
            step++;
        }

        return -1;
    }
}

//如果和127统一格式
class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> deadSet = new HashSet<String>(Arrays.asList(deadends));
        if(deadSet.contains(target) || deadSet.contains("0000")) return -1;
        
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        
        beginSet.add("0000");
        endSet.add(target);
        int step = 0;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            //let beginSet become the smaller set
            if(beginSet.size()>endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> nextlevel = new HashSet<String>();
            for(String digits : beginSet){
                for(int i=0; i<digits.length(); i++){
                    StringBuilder sb = new StringBuilder(digits);
                    char c = digits.charAt(i);
                    char up = (char)(c=='9'? '0' : c+1);
                    char down = (char)(c=='0'? '9' : c-1);

                    sb.setCharAt(i, up);
                    String upStr = sb.toString();
                    sb.setCharAt(i, down);
                    String downStr = sb.toString();
                    if(endSet.contains(upStr) || endSet.contains(downStr))
                        return step+1;
                    
                    if(!deadSet.contains(upStr)){
                        nextlevel.add(upStr);
                        deadSet.add(upStr);
                    }
                    if(!deadSet.contains(downStr)){
                        nextlevel.add(downStr);
                        deadSet.add(downStr);
                    }
                }
            }
            beginSet = nextlevel;
            step++;
        }
        
        return -1;
    }
}