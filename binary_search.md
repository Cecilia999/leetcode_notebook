# Binary Search

一般而言，当一个题目出现以下特性时，你就应该立即联想到它可能需要使用二分查找：

待查找的数组有序或者部分有序
要求时间复杂度低于 O(n)，或者直接要求时间复杂度为 O(log n)

## 二分搜索的经典写法。需要注意的三点：

1. 循环退出条件，注意是 low <= high，而不是 low < high。
2. mid 的取值，mid := low + (high-low)/2 --->>> because if lo and hi are very large, (lo + hi)/2 might potentially cause overflow.
3. low 和 high 的更新。low = mid + 1，high = mid - 1。

**java**

```java
public int binarySearchMatrix(int[] nums, int target){
  int low=0, high=nums.length-1;

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

```go
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

## 二分搜索的变种写法。有 4 个基本变种:

### 1. 查找第一个与 target 相等的元素，时间复杂度 O(logn)

```
// 二分查找第一个与 target 相等的元素，时间复杂度 O(logn)
func searchFirstEqualElement(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + ((high - low) >> 1)
		if nums[mid] > target {
			high = mid - 1
		} else if nums[mid] < target {
			low = mid + 1
		} else {

      // 找到第一个与 target 相等的元素
      // 在这个else statement里首先nums[mid]就==target
      //如果mid==0，已经是第一个数了
      //或者mid的前一位不是target，因为是sorted array，那当前mid必须是第一个target

			if (mid == 0) || (nums[mid-1] != target) {
				return mid
			}
			high = mid - 1
		}
	}
	return -1
}
```

### 2. 查找最后一个与 target 相等的元素，时间复杂度 O(logn)

```
// 二分查找最后一个与 target 相等的元素，时间复杂度 O(logn)
func searchLastEqualElement(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + ((high - low) >> 1)
		if nums[mid] > target {
			high = mid - 1
		} else if nums[mid] < target {
			low = mid + 1
		} else {
			if (mid == len(nums)-1) || (nums[mid+1] != target) { // 找到最后一个与 target 相等的元素
				return mid
			}
			low = mid + 1
		}
	}
	return -1
}
```

### 3. 查找第一个大于等于 target 的元素，时间复杂度 O(logn)

```
// 二分查找第一个大于等于 target 的元素，时间复杂度 O(logn)
func searchFirstGreaterElement(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + ((high - low) >> 1)
		if nums[mid] >= target {
			if (mid == 0) || (nums[mid-1] < target) { // 找到第一个大于等于 target 的元素
				return mid
			}

      //如果当前nums[mid]>=target但不是第一个的话，说明mid太大了，decreas high
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
```

### 4. 查找最后一个小于等于 target 的元素，时间复杂度 O(logn)

```
// 二分查找最后一个小于等于 target 的元素，时间复杂度 O(logn)
func searchLastLessElement(nums []int, target int) int {
	low, high := 0, len(nums)-1
	for low <= high {
		mid := low + ((high - low) >> 1)
		if nums[mid] <= target {
			if (mid == len(nums)-1) || (nums[mid+1] > target) { // 找到最后一个小于等于 target 的元素
				return mid
			}
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}
```

## 题目

### 1. 在基本有序的数组中用二分搜索

### 1.1 在山峰数组中找山峰, 旋转有序数组中找分界点

- [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/):  
  [java](/solution_java/0033_Search_in_Rotated_Sorted_Array.java)
- [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/):  
  [java](/solution_java/0081_Search_in_Rotated_Sorted_Array_II.java)
- [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/):  
  [java](/solution_java/0153_Find_Minimum_in_Rotated_Sorted_Array.java)
- [154. Find Minimum in Rotated Sorted Array ii](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/):  
  [java](/solution_java/0154_Find_Minimum_in_Rotated_Sorted_Array_II.java)
- [852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)：
  [java](/solution_java/0852_Peak_Index_in_a_Mountain_Array.java)

### 1.2 查找第一个与 target 相等的元素 / 查找最后一个与 target 相等的元素 / 查找第一个大于等于 target 的元素 / 查找最后一个小于等于 target 的元素

- [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/):  
  [java](/solution_java/0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array.java)

  **牛客网: **  
  这道题等同于剑指 offer 的[数字在升序数组中出现的次数](https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&&tqId=11190&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):  
  [java](/牛客网/数字在升序数组中出现的次数.java)

- [35 Search Insert Position](https://leetcode.com/problems/search-insert-position/):  
  [java](/solution_java/0035_Search_Insert_Position.java)

### 1.3 2d array 的 binary search

思路：把 2d array 当作 1d 来计算 row & col index:

1. m \* n matrix convert to an array : matrix[x][y] => arr[x*n + y]
2. an array convert to m \* n matrix : arr[x] =>matrix[x / n][x % n];

- [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/):  
  [java](/solution_java/0074_Search_a_2D_Matrix.java)
- [240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/):
  [java](/solution_java/0240_Search_a_2D_Matrix_II.java)

### 2. max-min 最大值最小化问题

**参考：**

https://segmentfault.com/a/1190000039377221
