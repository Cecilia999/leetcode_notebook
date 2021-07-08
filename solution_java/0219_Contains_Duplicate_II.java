// 题目大意 #
// 如果数组里面有重复数字，并且重复数字的下标差值小于等于 K 就输出 true，如果没有重复数字或者下标差值超过了 K ，则输出 flase。

// 解题思路 #
// 这道题可以维护一个只有 K 个元素的 map，每次只需要判断这个 map 里面是否存在这个元素即可。
// 如果存在就代表重复数字的下标差值在 K 以内。map 的长度如果超过了 K 以后就删除掉 i-k 的那个元素，这样一直维护 map 里面只有 K 个元素。

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap();
        
//         for(int i=0; i<nums.length; i++){
//             if (map.containsKey(nums[i])) {
//                  if (i - map.get(nums[i]) <= k) 
//                      return true;
//             }
//             map.put(nums[i], i);
//         }
//         return false;
//     }
// }

//sliding window + hashset
//只存window size = k的numbers in hashset
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet();
        
        for(int i=0; i<nums.length; i++){
            if(i>k) 
                set.remove(nums[i-k-1]);     //i-k是窗口的长度，因为index从0开始所以再-1
            if(set.contains(nums[i])) 
                return true;
            set.add(nums[i]);
        }
         
        return false;
    }
}