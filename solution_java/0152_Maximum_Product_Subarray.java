//思路：
//一开始的思路是dp[i]=当前nums[0:i]subarray的最大乘积用max来保留最大值
//
//用两个数 imin，imax来保留目前为止的最大product和最小product并且只要动态更新这两个值

class Solution {
  public int maxProduct(int[] nums) {
      int max=nums[0], min = nums[0], res=nums[0];
      
      for(int i=1; i<nums.length; i++){
          //如果nums[i]是负数的话，那就swap max&min
          //if we see a negative number, the "candidate" for max should instead become the previous min product, because a bigger number multiplied by negative becomes smaller, hence the swap()
          if(nums[i]<0){
              int temp = max;
              max = min;
              min = temp;
          }
          max = Math.max(max*nums[i], nums[i]);
          min = Math.min(min*nums[i], nums[i]);
          
          res = Math.max(max, res);
      }
      return res;
  }
}