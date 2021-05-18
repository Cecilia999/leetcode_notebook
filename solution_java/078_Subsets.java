class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      //用一个list来存所有的subsets，用一个templist来存当前的subset
      
      backtrackArray(list, new ArrayList<Integer>(), nums, 0);
      return list;
  }
  
  private void backtrackArray(List<List<Integer>> list, List<Integer> templist, int [] nums, int start){
      //先把上一轮的templist加到list里
      list.add(new ArrayList<Integer>(templist));     //必须创一个和templist值一样的新list加进去，不然每个templist的值是同步更改的
      System.out.println(templist);
      System.out.println(list);
      for(int i=start; i<nums.length; i++){
          templist.add(nums[i]);
          backtrackArray(list, templist, nums, i+1);
          templist.remove(templist.size()-1); //退回来之后要把templist清空以便explore一个新的path
      }
  }
}