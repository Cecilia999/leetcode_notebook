class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      backtrackCombinationSum3(list, new ArrayList<Integer>(), k, n, 1);
      return list;
  }
  
  private void backtrackCombinationSum3(List<List<Integer>> list, List<Integer> templist, int k, int target, int start){       
      if(templist.size()==k){  
          if(target==0)
              list.add(new ArrayList<Integer>(templist));            
          return;
      }
      
      //i=start!
      for(int i=start; i<=9; i++){            
          if(target-i>=0){                
              templist.add(i);
              backtrackCombinationSum3(list, templist, k, target-i, i+1);
              templist.remove(templist.size() - 1);
          }
      }
  }
}