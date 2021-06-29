//思路
//这道题是136的加强版，136只有一个数只出现1次，这道题有两个数只出现一次
//1. 依旧是用xor去除其他出现过两次的数字
//得到a xor b

//2. 把 a xor b分开成a和b
//因为 a和b是不相同的，所以一定有至少一位一位是a和b不同
//而 xor中1代表的就是两个数不相同的部分（因为相同的bit是0）
//所以我们用last set bit=1来区分a和b
// lsb = xor_res ^ -xor_res
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor_res = 0;
        for(int i=0; i<nums.length; i++){
            xor_res ^= nums[i];
        }
        
        int flag = xor_res & -xor_res;
        
        //把nums分成两组，num&flag == 0 为一组，==1为另外一组
        //a和b必定会被分开
        //分别xor这两组
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            if((nums[i]&flag) == 0)
                res[0]^=nums[i];
            else
                res[1]^=nums[i];
        }
        
        return res;
    }
}