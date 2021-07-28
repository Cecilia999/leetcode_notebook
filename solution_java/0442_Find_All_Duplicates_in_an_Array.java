// 题目大意
// 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
// 找到所有出现两次的元素。
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

// 解题思路
// 不用到任何额外空间即原地交换
// 这题和41题的思路一样，把每个数字放到他对应的index上，如果对应的index已经是正确的值则不交换
// 所有没有被放到正确index上的值则是数组中重复的部分
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]

// 还有另外一种方法是，出现过一次的值把它对应位置的nums[i]变为负数
// 即出现过两次的值对应的nums[i]是正数，return这些正数

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++){
            while(nums[nums[i]-1]!=nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        
         for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1)
                res.add(nums[i]);
         }
        
        return res;
    }
}