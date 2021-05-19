//思路：对撞指针start和end
//height更矮的那一边移动
//每次都要计算面积
class Solution {
  public int maxArea(int[] height) {
      int most=0, start=0, end = height.length-1;
      
      for(; start<end;){
          if(height[start]>height[end]){
              most=Math.max(height[end]*(end-start), most);
              end--;
          }
          else {
              most=Math.max(height[start]*(end-start), most);
              start++;
          }
      }
      return most;
  }
}