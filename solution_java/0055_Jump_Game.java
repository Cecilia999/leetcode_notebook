//思路
//对于每个index，他可以跳到的最远是当前它的位置i+nums[i]
//用一个maxjump记录所有到当前这个index为止可以跳到的最远距离
//当i>maxjump说明到达不了last index（比如接着几个nums[i]都为0的情况）:
//  [1, 3, 0, 0, 0, 0]

class Solution {
  public boolean canJump(int[] nums) {
      int max = 0;
      
      for(int i=0; i<nums.length; i++){
          if(i>max)
              return false;
          max = Math.max(nums[i]+i, max);
      }
      
      return true;
  }
}