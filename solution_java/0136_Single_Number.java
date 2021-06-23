//题目要求use only constant extra space. 不能用辅助空间，不能构造一个新的data structure来储存数组中每个数字出现的情况

//这道题的related topic是bit manipulation
//其他每个数字都出现两次，只有一个数字出现一次

//可以用elusive or的特性：
//1. x ^ x = 0
//2. XOR is commutative, a ^ b = b ^ a 所以顺序不重要，只要会XOR两次，就会抵消
//3. x ^ 0 = x
//4. a number XOR by another number twice makes no change on original number, a ^ b ^ b = a ^ 0 = a

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res = res ^ nums[i];
        }
        
        return res;
    }
}