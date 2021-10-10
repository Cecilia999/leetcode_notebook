# 4. Median of Two Sorted Arrays

## 题目大意

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

## 解题思路

### 1. To get a median of 2 sorted array, first we need to know how to get a median of 1 sorted array.

According to the definition of median, the median is used for dividing a set into two equal length subset, and one subset is always greater than is other set.

### 2. lets say we have two sorted array A & B

```
      left_A             |        right_A
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
      left_B             |        right_B
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
```

length(A) = m -->> cut i could be = 0~m, length(left_A) = i, length(right_A) = m-i
length(B) = n -->> cut j could be = 0~n, length(left_B) = j, length(right_B) = m-j

if we want to find the median of this two sorted array, we need to ensure:

1. length of left_part == length of right_part:
   **i+j == m-i + m-j** -->> i+j == half_len(m+n)
2. max(left_part) <= min(right_part)
   看第三点

### 3. 题目要求时间复杂度是 O(log(m+n)), 从而联想到二分法 binary search

先比较两个 array 的长度，为了时间最少选择二分搜索长度短的数
对于 nums1 and nums2
nums1: ……………… nums1[mid_num1-1] | nums1[mid_num1] ……………………
nums2: ……………… nums2[mid_num2-1] | nums2[mid_num2] ……………………
找出满足条件：
nums1[midA-1] ≤ nums2[midB] && nums2[midB-1] ≤ nums1[midA
找到切分的中线之后分两种情况

1. len1 + len2 是奇数：
   return median = max(nums1[midA-1], nums2[midB-1])
2. len1 + len2 是偶数：
   max_left = max(nums1[midA-1], nums2[midB-1])
   min_right = min(nums1[midA], nums2[midB])
   return median = (max_left + min_right) / 2

```java
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

      int low=0, high=len1, half_len=(len1+len2+1)/2; //奇数的时候return max_left, left part会多一个
      int mid_num1=0, mid_num2=0;
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

      //计算max_left
      if(mid_num1 == 0) max_left = nums2[mid_num2-1];
      else if(mid_num2 == 0) max_left = nums1[mid_num1-1];
      else max_left = Math.max(nums1[mid_num1-1], nums2[mid_num2-1]);

      if((len1+len2)%2 == 1) return max_left;

      //计算min_right
      if(mid_num1 == len1) min_right = nums2[mid_num2];
      else if(mid_num2 == len2) min_right = nums1[mid_num1];
      else min_right = Math.min(nums1[mid_num1], nums2[mid_num2]);

      return (max_left + min_right) / 2.0;
  }
}
```

```java
//二刷
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m>n)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high=m, half_len = (m+n+1)/2;  //奇数的时候return max_left, left part会多一个
        int i=0, j=0;
        int max_left = 0, min_right = 0;
        while(low<=high){
            i= low + (high-low)/2;
            j = half_len - i;

            if(i>0 && nums1[i-1]>nums2[j])
                high = i-1;
            else if(i<m && nums2[j-1]>nums1[i])
                low = i+1;
            else
                break;
        }

        //计算max_left
        if(i==0){
            max_left = nums2[j-1];
        }
        else if(j==0){
            max_left = nums1[i-1];
        }
        else{
            max_left = Math.max(nums1[i-1], nums2[j-1]);
        }

        if((m+n)%2 == 1) return max_left;

        //计算min_right
        if(i==m)
            min_right = nums2[j];
        else if(j==n)
            min_right = nums1[i];
        else
            min_right = Math.min(nums1[i], nums2[j]);

        return (max_left + min_right) / 2.0;
   }
}
```
