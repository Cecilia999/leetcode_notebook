// 题目大意
// 698. 划分为k个相等的子集
// 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

// 示例 1：
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
// 输出： True
// 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。

// 提示：

// 1 <= k <= len(nums) <= 16
// 0 < nums[i] < 10000

// 解题思路
// backtrack

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        
        if(sum%k!=0 || max>sum/k) 
            return false;
        boolean[] used = new boolean[nums.length];
        
        return backtrack(nums, used, k, sum/k, 0);
    }
    
    public boolean backtrack(int[] nums, boolean[] used, int k, int target, int start){
        if(k == 0){
            return true;
        }
        if(target == 0) 
            return backtrack(nums, used, k-1, 0, 0);
        
        for(int i=start; i<nums.length; i++){
            if(used[i]) continue;
            if(target - nums[i] < 0) continue;
            
            used[i] = true;
            if(backtrack(nums, used, k, target-nums[i], i+1))
                return true;
            used[i] = false;
        }
        
        return false;
    }
}