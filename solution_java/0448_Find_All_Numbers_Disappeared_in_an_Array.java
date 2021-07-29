// 题目大意
// 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
// 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
// 输入：nums = [4,3,2,7,8,2,3,1]
// 输出：[5,6]

// 解题思路
// 和41题一样，原地哈希

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
                res.add(i+1);
        }
        
        return res;
    }
}