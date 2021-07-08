//解题思路
//因为是要求o(n)，input的array是无序的，array.sort()是quicksort time complexity=O(NlogN)
//所以要用一种可以判断是不是contains x+1，x+2，x+3... 的数据结构 -->> hashset
//algorithm idea：
//go through the numbers. If the number x is the start of a streak (i.e., x-1 is not in the set), then test y = x+1, x+2, x+3, ... and stop at the first number y not in the set. 
//对于每个nums中的数字都放入hashset，对set中的each x判断：
//1. x-1是不是不在set中(x是一个新的start)
//2. x+1，x+2，x+3...是不是在set中，直到发现第一个不在的y
//这一段consecutive sequence的长度为y-x
//mantain最长的consecutive sequence的长度

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int maxlen = 0;
        for(int num : nums){
            set.add(num);
        }
        
        for(int x : set){
            if(!set.contains(x-1)){
                int y = x+1;
                while(set.contains(y))
                    y++;
                maxlen = Math.max(maxlen, y-x);
            }
        }
        
        return maxlen;
    }
}