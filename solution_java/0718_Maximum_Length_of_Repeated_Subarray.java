//Subarray必须是连续的
//这题就相当于 longest common string的array version
//dp[i][j] = length of longest common array of nums1[1:i-1] and num2[1:j-1]

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(nums1[i-1]==nums2[j-1]){
                    //因为subarray必须是连续的
                    dp[i][j] = dp[i-1][j-1]+1;
                    
                    max = Math.max(max, dp[i][j]);
                }                
            }
        }
        
        return max;
    }
}