// 题目大意
// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
// 输入：nums = [9,1,7,9,7,9,7]
// 输出：1

// 解题思路：
// 建立一个长度为 32 的数组 counts，记录遍历过程中各位出现的次数（一定是3的倍数+1，因为只有一个数是不重复的），
// 最后对各位取余，还原构造该数即可。
// 实际上，只需要修改求余数值 m，即可实现解决 除了一个数字以外，其余数字都出现 m 次 的通用问题。

class Solution {
    public int singleNumber(int[] nums) {
        //构造一个长度为32的int
        int[] bitcount = new int[32];
        int ans = 0;

        //记录遍历过程中各位出现的次数（一定是3的倍数+1，因为只有一个数是不重复的），最后对各位取余，还原构造该数。
        for(int num: nums){
            int res = num;
            for(int i=0; i<32; i++){
                // res & 1 得到最后一位是1/0
                bitcount[i] += (res & 1);
                res >>>= 1;
            }
        }

        //对各位取余%3
        for(int i=0; i<32; i++){
            bitcount[i] %= 3;
        }

        //还原该数，因为bitcount是从最后一位开始构造的，要反过来
        // 1 |= bitcount[i] -->> bitcount[i] = 1 返回1 else 返回0 
        for(int i=31; i>=0; i--){
            ans <<= 1;
            ans |= bitcount[i];
        }

        return ans;
    }
}

时间复杂度 O(N) ： 其中 N 位数组 nums 的长度；遍历数组占用 O(N) ，每轮中的常数个位运算操作占用 O(1) 。
空间复杂度 O(1) ： 数组 countscounts 长度恒为 32，占用常数大小的额外空间。