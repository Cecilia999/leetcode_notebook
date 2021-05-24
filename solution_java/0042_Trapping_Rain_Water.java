//这种题的思路就是search from left and right at the same time
//loop stop when left pointer meets right pointer
// if height[left]<=height[right] move left pointer
//      if height[left]<maxleft
//          可以储存积水
//      否则储存不了，更新maxleft
// else move right pointer
//      同理

//蓄水的前提是左右两边比中间高，所以只有当当前高度小于maxleft/maxright的时候可以蓄水

class Solution {
  public int trap(int[] height) {
      int left=0, right=height.length-1, maxLeft=0, maxRight=0, res = 0;
      
      while(left<=right){
          if(height[left]<=height[right]){
              if(height[left]>=maxLeft) maxLeft = height[left];
              else res += maxLeft-height[left];
              
              left++;    
          }
          else{
              if(height[right]>=maxRight) maxRight = height[right];
              else res += maxRight-height[right];
              
              right--;    
          }
      }
      
      return res;
  }
}