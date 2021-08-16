// 题目大意
// 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
// 请你找出并返回那个只出现了一次的元素。
// 示例 1：
// 输入：nums = [2,2,3,2]
// 输出：3
// 示例 2：
// 输入：nums = [0,1,0,1,0,1,99]
// 输出：99

// 提示：
// 1 <= nums.length <= 3 * 104
// -231 <= nums[i] <= 231 - 1
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次

// 解题思路
// 用位运算

class Solution {
    public int singleNumber(int[] nums) {
        int[] bitcounts = new int[32];

        for(int num : nums){
            for(int i=0; i<32; i++){
                bitcounts[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0;
        for(int i=31; i>0; i--){
            res |= bitcounts[i]%3;
            res <<= 1; 
        }
        res |= bitcounts[0]%3;
        
        // int res = 0;   //res不管initialize成几都会因为溢出被覆盖
        // for(int i=31; i>=0; i--){
        //     res <<= 1; 
        //     res |= bitcounts[i]%3;
        // }

        return res;
    }
}