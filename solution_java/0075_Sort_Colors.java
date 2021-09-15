// 题目大意
// 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
// 并按照红色、白色、蓝色顺序排列。
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]

// 解题思路
// 两个指针p0，p1. 
// 如果nums[i]==0 就和nums[p0]交换， p0，p1同时向后移
// 如果nums[i]==1 就和nums[p1]交换，p1向后移
// 注意edge case nums[i]==0 但是nums[p0] == 1

class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                
                //edge case, 如果nums[p0]位置的数字==1，否则nums[i]就直接跳过了
                if(nums[i]==1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }      
            else if(nums[i]==1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
            
        }
    }
}