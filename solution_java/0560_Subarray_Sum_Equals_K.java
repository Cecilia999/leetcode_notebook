// 题目大意
// 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

// 示例 1 :
// 输入:nums = [1,1,1], k = 2
// 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

// 说明 :
// 数组的长度为 [1, 20,000]。
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

// 解题思路：
// 用前缀和 HashMap<Integer, Integer> preSum
// 记住preSum[i]代表的是前i项nums[i]的和
// nums[i] 到 nums[j]的和可以表示为 = preSum[j]-preSum[i]

// 所以这道题转化为查找preSum[j] - preSum[i] == k 的个数 ====>>>> twoSum的变形

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        //preSum(前缀和， 前缀和的个数)
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(preSum.containsKey(sum-k)){
                count += preSum.get(sum-k);
            }

            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}