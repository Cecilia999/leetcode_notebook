//思路：helper function里用一个boolean array来判断每个num是不是被用过了，替换contains
//如果前面重复的num还没有被使用过，则说明当前num是重复的
class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      Arrays.sort(nums); //有重复的情况下必须要sort
      backtrackPermutation2(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
      return list;
  }
  
  private void backtrackPermutation2(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] used){
      if(templist.size()==nums.length)
          list.add(new ArrayList<>(templist));
      
      for(int i=0; i<nums.length; i++){
          
          if(used[i] || i>0 && !used[i-1] && nums[i]==nums[i-1]) continue;
          
          used[i]=true;
          templist.add(nums[i]);
          backtrackPermutation2(list, templist, nums, used);
          templist.remove(templist.size()-1);
          used[i]=false;
      }
  }
}