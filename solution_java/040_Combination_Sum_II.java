//与1的区别是input candidate可以是重复的
class Solution {
  public List<List<Integer>> combinationSum2(int[] nums, int target) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      Arrays.sort(nums); //有重复的情况下都需要Arrays.sort()
      backtrackComSum2(list, new ArrayList<Integer>(), nums, target, 0);
      return list;
  }
  
  private void backtrackComSum2(List<List<Integer>> list, ArrayList<Integer> templist, int[] nums, int target, int start){
      if(target==0) 
          list.add(new ArrayList<>(templist));
      
      for(int i=start; i<nums.length; i++){
          if(i>start && nums[i]==nums[i-1]) continue;
          if(target-nums[i]<0) continue;
          
          templist.add(nums[i]);
          backtrackComSum2(list, templist, nums, target-nums[i], i+1);
          templist.remove(templist.size()-1);
      }
  }
}