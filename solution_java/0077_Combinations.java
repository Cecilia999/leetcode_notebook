//思路：同理39， 40题
//     只需要多加一个剪枝条件：
//        if(templist.size()==k)
//          list.add(new ArrayList<>(templist));
class Solution {
  public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      backtrackCombine(list, new ArrayList<Integer>(), n, k, 0);
      return list;
  }
  
  private void backtrackCombine(List<List<Integer>> list, List<Integer> templist, int n, int k, int start){
      if(templist.size()==k)
          list.add(new ArrayList<>(templist));
      
      for(int i=start; i<n; i++){
          templist.add(i+1);
          backtrackCombine(list, templist, n, k, i+1);
          templist.remove(templist.size()-1);
      }
  }
}