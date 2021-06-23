//要求找出 0, 1, 2, ..., n 中缺失的那个数。还是利用异或的性质，X^X = 0。
//这里我们需要构造一个 X，用数组下标就可以了。数字下标是从 [0，n-1]，数字是 [0，n]，
//依次把数组里面的数组进行异或，把结果和 n 再异或一次，中和掉出现的数字，
//剩下的那个数字就是之前没有出现过的，缺失的数字。
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res = res ^ i ^ nums[i];
        }
        
        return res;
    }
}