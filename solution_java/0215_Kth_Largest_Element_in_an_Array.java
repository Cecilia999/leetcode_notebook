//思路
//像quicksort一样用divide and conquer的方法
//在快排的 partition 操作中，每次 partition 操作结束都会返回一个点，这个标定点的下标和最终排序之后有序数组中这个元素所在的下标是一致的。
//利用这个特性，我们可以不断的划分数组区间，最终找到第 K 大的元素(等同于第nums.length-k小的元素)
//执行一次 partition 操作以后，
//如果这个元素的下标比 K 小，那么接着就在右边的区间继续执行 partition 操作；
//如果这个元素的下标比 K 大，那么就在左边的区间继续执行 partition 操作；
//如果相等就直接输出这个下标对应的数组元素即可。
class Solution {
  public int findKthLargest(int[] nums, int k) {

    //find kth largest == find nums.length-k th smallest
    return selectKthSmallest(nums, 0, nums.length-1, nums.length-k);
      
  }
  
  //partition + recursion -->> quick sort
  private int selectKthSmallest(int[] nums, int start, int end, int k){
      int pivot = start, l=start, r=end;
      
      while(l<r){

        //l必须始终<r
        //先移动r指针，再移动l指针

        while(nums[r]>=nums[pivot] && l<r)
            r--;
        while(nums[l]<=nums[pivot] && l<r) 
            l++;
        
        //swap l & r
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
      }
      
      //swap l & pivot
      int temp = nums[pivot];
      nums[pivot] = nums[l];
      nums[l] = temp;
      
      
      if(l==k)
          return nums[l];
      else if(l<k)
          return selectKthSmallest(nums, l+1, end, k);
      else
          return selectKthSmallest(nums, start, l-1, k);
  }
}