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
        // Edge cases
        if(nums.length == 0)    return 0;
        
        // Sliding window -- No, contains negative number
        // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.  
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, 1);
        for(int cur : nums) {
            sum += cur;
            if(map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result; 
    }
}