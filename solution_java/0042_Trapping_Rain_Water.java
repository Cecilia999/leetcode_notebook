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
        int left=0, right=height.length-1;
        int maxLeft=0, maxRight=0;
        int res = 0;
        
        while(left<=right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            
            // maxLeft is smaller than maxRight, so the (maxLeft - height[left]) water can be stored
            if(maxLeft<maxRight){
                if(height[left]<maxLeft){
                    res += maxLeft - height[left];
                }
                left++;
            }
            else{
                if(height[right]<maxRight){
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        
        return res;
    }
}