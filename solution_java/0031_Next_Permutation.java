// 题目大意
// 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
// 必须 原地 修改，只允许使用额外常数空间。

// 解题思路
// “下一个排列”的定义是：给定数字序列的字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
// 我们可以将该问题形式化地描述为：给定若干个数字，将其组合为一个整数。如何将这些数字重新排列，以得到下一个更大的整数。
// 如 123 下一个更大的数为 132。如果没有更大的整数，则输出最小的整数。

// 以 1,2,3,4,5,6 为例，其排列依次为：
// 123456
// 123465
// 123546
// ...
// 654321
// 可以看到有这样的关系：123456 < 123465 < 123546 < ... < 654321。

// 算法过程
// 1. 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
// 2. 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
// 3. 将 A[i] 与 A[k] 交换
// 4. 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
// 5. 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<2) return;
        int i=nums.length-2, j=nums.length-1;
        
        while(i>=0 && nums[i]>=nums[j]){
            i--;
            j--;
        }
        
        if(i>=0){
            int k=nums.length-1;
            while(k>=j  &&  nums[k]<=nums[i])
                k--;
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        
        for(int start=i+1, end=nums.length-1; start<=end; start++, end--){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        
        return;
    }
}