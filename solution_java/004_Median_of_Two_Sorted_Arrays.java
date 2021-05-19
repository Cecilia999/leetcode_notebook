//思路： 题目要求时间复杂度是O(log(m+n)), 从而联想到二分法
//先比较两个array的长度，为了时间最少选择二分搜索长度短的数组

//对于nums1 and nums2
// nums1:  ……………… nums1[mid_num1-1] | nums1[mid_num1] ……………………
// nums2:  ……………… nums2[mid_num2-1] | nums2[mid_num2] ……………………
//找出满足条件：
//nums1[midA-1] ≤ nums2[midB] && nums2[midB-1] ≤ nums1[midA]

//找到切分的中线之后分两种情况
//1. len1 + len2 是奇数：
//  return median = max(nums1[midA-1], nums2[midB-1])
//2. len1 + len2 是偶数：
//  max_left = max(nums1[midA-1], nums2[midB-1])
//  min_right = min(nums1[midA], nums2[midB])
//  return median = (max_left + min_right) / 2
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      //为了提高效率，对更短的array进行loop
      int len1 = nums1.length, len2 = nums2.length;
      if(len1>len2)
          return findMedianSortedArrays(nums2, nums1);
      
      //用binary search找出在nums1的切割点，使得：
      //mid_num1+mid_num2 = half_len (两个array总长度的一半)
      //nums1[mid_num1-1]<nums2[mid_num2]
      //nums2[mid_num2-1]<nums1[mid_num1]
      
      int low=0, high=len1, half_len=(len1+len2+1)/2, mid_num1=0, mid_num2=0;
      int max_left = 0, min_right = 0;
      
      while(low<=high){
          
          // nums1:  ……………… nums1[mid_num1-1] | nums1[mid_num1] ……………………
          // nums2:  ……………… nums2[mid_num2-1] | nums2[mid_num2] ……………………
          
          mid_num1 = (low+high)/2;
          mid_num2 = half_len - mid_num1;
          
          //mid_num1 is too large, decrease high to decrease mid_num1
          if(mid_num1 > 0 && nums1[mid_num1-1]>nums2[mid_num2])
              high = mid_num1-1;
          //mide_num1 is too small, increase high to increase mid_num1
          else if(mid_num1<len1 && nums2[mid_num2-1]>nums1[mid_num1])
              low = mid_num1+1;
          //mid_num1 is perfect
          else
              break;
      }
      
      //计算median = (max_left + min_right) / 2
      //分len1+len2是奇数偶数两种情况        
      if(mid_num1 == 0) max_left = nums2[mid_num2-1];
      else if(mid_num2 == 0) max_left = nums1[mid_num1-1];
      else max_left = Math.max(nums1[mid_num1-1], nums2[mid_num2-1]);
      
      if((len1+len2)%2 == 1) return max_left;
      
      if(mid_num1 == len1) min_right = nums2[mid_num2];
      else if(mid_num2 == len2) min_right = nums1[mid_num1];
      else min_right = Math.min(nums1[mid_num1], nums2[mid_num2]);
      
      return (max_left + min_right) / 2.0;
  }
}