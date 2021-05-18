class Solution {
  public List<List<Integer>> permute(int[] nums) {
      //思路，和subset1、2一样 唯一的不同是展开每条路的时候，先判断当前数字有没有在templist里已经出现过了，出现过就跳过
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      backtrackPermutation1(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
      return list;
  }
  
  //不需要i从start开始，i每次都从0开始,存在过的num就不加入templist，当templist的长度等于nums的长度的时候就加进list里
  
  // private void backtrackPermutation1(List<List<Integer>> list, List<Integer> templist, int[] nums){
  //     if(templist.size()==nums.length)
  //         list.add(new ArrayList<>(templist));
  //     for(int i=0; i<nums.length; i++){
  
  //         //contains 是O(n) 可以想permutation2一样用一个boolean array used来记录是否用过， O(1)
  //         if(templist.contains(nums[i])) continue;
 
  //         templist.add(nums[i]);
  //         backtrackPermutation1(list, templist, nums);
  //         templist.remove(templist.size()-1);
  //     }
  // }
  
  private void backtrackPermutation1(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] used){
      if(templist.size()==nums.length)
          list.add(new ArrayList<>(templist));
      for(int i=0; i<nums.length; i++){
          if(used[i]) continue;
          
          used[i]=true;
          templist.add(nums[i]);
          backtrackPermutation1(list, templist, nums,used);
          templist.remove(templist.size()-1);
          used[i]=false;
      }
  }
}