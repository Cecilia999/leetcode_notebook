# Binary Search

### 二分搜索的经典写法。需要注意的三点：

循环退出条件，注意是 low <= high，而不是 low < high。
mid 的取值，mid := low + (high-low)/2
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

查找第一个与 target 相等的元素，时间复杂度 O(logn)
查找最后一个与 target 相等的元素，时间复杂度 O(logn)
查找第一个大于等于 target 的元素，时间复杂度 O(logn)
查找最后一个小于等于 target 的元素，时间复杂度 O(logn)

### 1. 在基本有序的数组中用二分搜索

1. 在山峰数组中找山峰

2. 旋转有序数组中找分界点

### 2. max-min 最大值最小化问题

**参考：**

https://segmentfault.com/a/1190000039377221
