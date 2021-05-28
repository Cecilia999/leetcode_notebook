//思路：backtrack/dfs 和46题一样只不过多了一个剪枝条件：
//  要求数字可以被它对应的下标 + 1 整除，或者下标 + 1 可以整除下标对应的这个数字
//不是最优解法

class Solution {
  public int countArrangement(int n) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      backtrack(list, new ArrayList<Integer>(), new boolean[n], n);
      
      return list.size();
  }
  
  private void backtrack(List<List<Integer>> list, List<Integer> templist, boolean[] used, int n){
      if(templist.size() == n) 
          list.add(new ArrayList<>(templist));
      
      for(int i=0; i<n; i++){
          if(used[i])
              continue;
          
          //since i start from 0, perm[i] = i+1
          if((i+1)%(templist.size()+1)==0 || (templist.size()+1)%(i+1) == 0){
              used[i]=true;
              templist.add(i+1);
              backtrack(list, templist, used, n);
              templist.remove(templist.size()-1);
              used[i]=false;
          }
      }
  }
}