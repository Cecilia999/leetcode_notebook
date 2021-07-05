// 题目大意 #
// 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：

// answer[i] % answer[j] == 0 ，或
// answer[j] % answer[i] == 0
// 如果存在多个有效解子集，返回其中任何一个均可。

// 解题思路 #
// 首先这道题是dp
// 根据整除的特性，如果一个数a可以整除数b，那么也可以整除所有可以被数b整除的数
// e.g. 8%4==0 4%2==0 可以得到8%2==0

// 这道题就转化成找一个longest increasing sequence s.t.
// 里面的数可以互相整除

// dp[i]=nums[i]可以整除nums[:i]的数量
// 可以用一个pre[]来记录nums[i]可以整除的最大值，每当dp[i]更新，说明dp[i]的pre[]需要更新了

//不然的话就用maxsize和maxvalue/nums[i]==0来一个一个找回

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int maxSize = 0, index=-1;
        
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    pre[i]=j;
                }
            }
            if(maxSize<dp[i]){
                //store the largest size and the index i
                //which is the largest subset so far
                maxSize = dp[i];
                index = i;
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        while(index>-1){
            res.add(nums[index]);
            index = pre[index];
        }
        
        // int maxValue = nums[index];
        // for(int i=nums.length-1; i>=0; i--){
        //     if(dp[i]== maxSize && maxValue%nums[i]==0){
        //         res.add(nums[i]);
        //         maxSize--;
        //         maxValue=nums[i];
        //     }
        // }
        return res;
    }
}