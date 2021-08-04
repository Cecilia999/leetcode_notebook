// 题目大意
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]

// 解题思路
// two pointer，fast遇到非0的就和slow交换，遇到0就跳过

class Solution {
    public void moveZeroes(int[] nums) {       
        for(int slow = 0, fast = 0; fast<nums.length; fast++){
            if(nums[fast]!=0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }       
        }
        
        return;
    }
}