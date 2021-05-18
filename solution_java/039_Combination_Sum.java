class Solution {
  public List<List<Integer>> combinationSum(int[] nums, int target) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      // Arrays.sort(nums)   //可以不用sort
      backtrackComSum1(list, new ArrayList<Integer>(), nums, target, 0);
      return list;
      
  }
  
  private void backtrackComSum1(List<List<Integer>> list, ArrayList<Integer> templist, int[] nums, int target, int start){
      if(target==0) 
          list.add(new ArrayList<>(templist));
      
      for(int i=start; i<nums.length; i++){
          if(target-nums[i]<0) continue;
          
          templist.add(nums[i]);
          backtrackComSum1(list, templist, nums, target-nums[i], i);  //不是i+1因为可以重复用element，不是从i=0开始因为不需要重复的combination
          templist.remove(templist.size()-1);              
      }
      
  }
}