// 题目大意
// 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
// 实现 NumArray 类：
// NumArray(int[] nums) 使用数组 nums 初始化对象
// int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
//  

// 示例：
// 输入：
// ["NumArray", "sumRange", "sumRange", "sumRange"]
// [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
// 输出：
// [null, 1, -1, -3]

// 解释：
// NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
// numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
// numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
// numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))

// 解题思路
// 构造器即算出input nums的前缀和
// 用preSum[i]-preSum[j] == num[i]+...+nums[j]得到range sum
// 注意i==0的特殊情况

class NumArray {
    private int[] preSum;
    
    //constructor处理input nums为前缀和array
    public NumArray(int[] nums) {      
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        this.preSum = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left==0)
            return preSum[right];
        return preSum[right]-preSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */