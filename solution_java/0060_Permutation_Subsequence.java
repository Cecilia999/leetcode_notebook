//这种方法的runtime太高
//尝试优化
// class Solution {
//     public String getPermutation(int n, int k) {
//         List<StringBuilder> sbList = new ArrayList<>();
//         permutation(sbList, new StringBuilder(), n, k, new boolean[n]);
//         return sbList.get(k-1).toString();
//     }
    
//     private void permutation(List<StringBuilder> sbList, StringBuilder sb, int n, int k, boolean[] used){
//         if(sbList.size()==k){
//             return;
//         }
//         if(sb.length()==n){
//             sbList.add(new StringBuilder(sb));
//         }
//         for(int i=0; i<n; i++){
//             if(used[i])
//                 continue;
//             used[i] = true;
//             sb.append(i+1);
//             permutation(sbList, sb, n, k, used);
//             sb.deleteCharAt(sb.length()-1);
//             used[i] = false;
//         }
//     }
// }

//用数学方法思考的话 就是考虑按照排列的顺序，第k个排列的第一个数会是什么，第二个数会是什么...第n个数会是什么
//对于n的每一位，要确认以当前数字开头的permutation的数量，数学公式是(n-1)！
    //e.g. n=4
    //1 {2, 3, 4}
    //2 {1, 3, 4}
    //3 {1, 2, 4}
    //4 {1, 2, 3}
    //对于每一个，后面三个数的排列都有3！=6种
    class Solution {
      public String getPermutation(int n, int k) {
          int[] factorial = new int[n+1];
          factorial[0] = 1;
          //给factorial赋值
          for(int i=1; i<=n; i++){
              factorial[i] = factorial[i-1]*i;
          }
          
          //index starts from 0
          k--;
          
          //create a list to store numbers
          //create a sb to store the kth permutation
          //initialize nums list
          List<Integer> nums = new ArrayList<Integer>();
          StringBuilder sb = new StringBuilder();
          for(int i=1; i<=n; i++){
              nums.add(i);
          }
          //nums={1, 2, 3, 4}
          
          //对于第一个到第n个数字
          for(int i=1; i<=n; i++){
              
              //calculate the index of nums for each position 1~n
              //update k
              int index = k/factorial[n-i];
              k=k-index*factorial[n-i];
              
              sb.append(nums.get(index));
              nums.remove(index);
          }
          
          return sb.toString();
      }
  }