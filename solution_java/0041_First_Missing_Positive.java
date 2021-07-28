// 题目大意
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 请你实现时间复杂度为 O(n) 空间复杂度O(1)。

// 算法思路
// 将数组视为哈希表 hashmap<nums[i], i>
// 第一遍遍历数组，两个loop，把每个数字放到index position对应的位置，比如数字3放到nums[2]，数字4放到nums[3]，并且是交换完继续查找
// 第二遍遍历数组，找到第一个index position对应的值不是index+1的那个，则index+1就是第一个缺失的正数

// while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
        // 满足在指定范围内、并且没有放在正确的位置上，才交换
        // 例如：数值 3 应该放在索引 2 的位置上
// }
 
class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++){
            //用while loop连续交换
            //顺序很重要！
            //nums[nums[i]-1]!=nums[i] 必须要在nums[i]>0 && nums[i]<=nums.length后面
            while(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]){
                
                //这里赋值有先后顺序
                //如果先把temp=nums[i]
                //nums[i] = nums[nums[i]-1]
                //nums[nums[i]-1] = temp会出错，
                //因为第三行nums[nums[i]-1] = temp里面的nums[i]已经变了
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return nums.length+1; //1-n都有，下一个是n+1
    }
}