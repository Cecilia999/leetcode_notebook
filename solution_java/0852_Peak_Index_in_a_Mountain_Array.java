//思路：
//二分法的思路就是找出如何判断是low需要increase还是high需要decrease
//这道题的分界点在于 arr[mid] vs arr[mid+1]
//arr[mid] > arr[mid+1]
//peak在mid的左侧
//arr[mid] < arr[mid+1]
//peak在mid的右侧

class Solution {
  public int peakIndexInMountainArray(int[] arr) {
      int low=0, high=arr.length-1;
      
      while(low<high){
          int mid = low + (high-low)/2;
          
          
          if(arr[mid]>=arr[mid+1])
              //因为peak可能就是arr[mid], high=mid-1会skip掉
              high=mid;
          else
              low=mid+1;
      }
      
      return low;
  }
}