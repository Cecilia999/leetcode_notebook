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

//优化写法，空间复杂度是O(n)，时间也更快
class Solution {
    private int count = 0;
    
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        backtrack(1, used, n);
        
        return count;
    }
    
    public void backtrack(int pos, boolean[] used, int n){
        if(pos>n){
            count++;
            return;
        }
        
        for(int i=1; i<=n; i++){
            if(used[i]) continue;

            if(pos % i == 0 || i % pos == 0){
                used[i] = true;
                backtrack(pos+1, used, n);
                used[i] = false;
            }
        }
    }
}