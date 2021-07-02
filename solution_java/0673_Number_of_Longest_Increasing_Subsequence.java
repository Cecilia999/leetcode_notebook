//这题是300题的进阶
//用另外一个count array来记录nums[i]的lis的个数

//每当dp[i]更新为dp[j]       count[i]=count[j]
//当找到dp[i] = dp[j] + 1   count[i] += count[j]

//每当max==dp[i]       res += count[i]
//每当max更新为dp[i]    res = count[i] 

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1, res=1;
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    if(1+dp[j]>dp[i]){
                        dp[i] = 1+dp[j];
                        count[i] = count[j];
                    }
                    else if(1+dp[j]==dp[i])
                        count[i] += count[j];
                }
            }
            
            if(max==dp[i])
                res += count[i];
            else if(max<dp[i]){
                max = dp[i];
                res = count[i];
            }
        }
        
        return res;
    }
}