class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      //注意，如果nums里有一样的数字的话，那么不处理会有重复的subsets
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      backtrackSubset2(list, new ArrayList<Integer>(), nums, 0);
      return list;    
  }
  
  private void backtrackSubset2(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
      list.add(new ArrayList<>(templist));
      for(int i=start; i<nums.length; i++){
          if(i>start && nums[i]==nums[i-1])  continue;   //i>start这个条件特别重要！！！ sort在这种duplicate的情况也是必须的
          //i>start 意味着我已经第一次走完了这一条路上所有nums都会出现的可能性
          
          templist.add(nums[i]);
          backtrackSubset2(list, templist, nums, i+1);
          templist.remove(templist.size()-1);
      }
  }
}