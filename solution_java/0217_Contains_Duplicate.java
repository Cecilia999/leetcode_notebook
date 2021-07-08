// 题目大意 #
// 这是一道简单题，如果数组里面有重复数字就输出 true，否则输出 flase。

// 解题思路 #
// 用 map/set 判断即可。

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums){
            if(!set.contains(num))
                set.add(num);
            else
                return true;
        }
        return false;
    }
}