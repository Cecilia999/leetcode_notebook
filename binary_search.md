# Binary Search

一般而言，当一个题目出现以下特性时，你就应该立即联想到它可能需要使用二分查找：

待查找的数组有序或者部分有序
要求时间复杂度低于 O(n)，或者直接要求时间复杂度为 O(log n)

### 二分搜索的经典写法。需要注意的三点：

循环退出条件，注意是 low <= high，而不是 low < high。         
mid 的取值，mid := low + (high-low)/2   --->>>  because if lo and hi are very large, (lo + hi)/2 might potentially cause overflow.       
low 和 high 的更新。low = mid + 1，high = mid - 1。           

**java**

```
public int binarySearchMatrix(int[] nums, int target){
  int low=0, high=0, len=nums.length;

  while(low<=high){
    int mid = low + (high-low)/2;

    if(nums[mid]==target)
      return mid;
    else if (nums[mid] > target)
      high = mid - 1;
    else
      low = mid + 1;
  }
  return -1;
}
```

**go**

```
func binarySearchMatrix(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + (high-low)>>1
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
```

### 二分搜索的变种写法。有 4 个基本变种:

- 查找第一个与 target 相等的元素，时间复杂度 O(logn)
- 查找最后一个与 target 相等的元素，时间复杂度 O(logn)
- 查找第一个大于等于 target 的元素，时间复杂度 O(logn)
- 查找最后一个小于等于 target 的元素，时间复杂度 O(logn)

### 1. 在基本有序的数组中用二分搜索

1. 在山峰数组中找山峰, 旋转有序数组中找分界点

- [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/):  
  [java](/solution_java/0033_Search_in_Rotated_Sorted_Array.java)
- [88. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/):  
  [java](/solution_java/0081_Search_in_Rotated_Sorted_Array_II.java)

### 2. max-min 最大值最小化问题

**参考：**

https://segmentfault.com/a/1190000039377221
