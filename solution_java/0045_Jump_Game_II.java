//思路：贪心算法
//用end表示每一次jump的时候，可以到达的下一个最远
//用max保留在i～end之间的每一个点可以到达最远
//每当i==end，就jump一次并且更新end=max

class Solution {
  public int jump(int[] nums) {
      int max=0, jump=0, end=0;
      
      //不需要loop最后一个index，因为只要能jump到最后一个index就可以了
      for(int i=0; i<nums.length-1; i++){

          max=Math.max(i+nums[i], max);

          if(i==end){
              jump++;
              end = max;
          }
          
      }
      return jump;
  }
}