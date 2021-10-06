// 题目大意
// 8 间牢房排成一排，每间牢房不是有人住就是空着。
// 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
// 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
// 否则，它就会被空置。
// （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
// 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
// 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。

//1. 判断nextday cell's occupied的情况的算法：
//      if(cell[i-1]==cell[i+1]) return 1;
//      else return 0;

//2. 在某天后会形成循环，一旦形成循环就break the loop
// return n%cycle
// 用hashset存string表示每天的cells情况，如果存在一模一样的说明已经形成了循环

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> cellSet = new HashSet<String>();
        boolean hasCycle = false;
        int cycle = 0;
        
        int[] next = cells;
        for(int i=0; i<n; i++){
            next = nextDay(next);
            //Arrays.toString()
            String cellStr = Arrays.toString(next);
            if(cellSet.contains(cellStr)){
                hasCycle = true;
                break;  //break的时候正好完成一个cycle，即next为下一个循环的起点
            }
            
            cellSet.add(cellStr);
            cycle++;
            cells = next;
        }
        
        if(hasCycle){
            n %= cycle;
            for(int i=0; i<n; i++){
                cells = nextDay(cells);
            }
        }
        
        return cells;
    }
    
    public int[] nextDay(int[] cells){
        //initialize a new array！
        int[] temp = new int[cells.length];
        for(int i=1; i<cells.length-1; i++){
            temp[i] = cells[i-1]==cells[i+1]? 1:0;
        }
        return temp;
    }
}