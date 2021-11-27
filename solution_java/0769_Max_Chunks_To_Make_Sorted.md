# 769. Max Chunks To Make Sorted

## problem

You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

Constraints:

n == arr.length
1 <= n <= 10
0 <= arr[i] < n
All the elements of arr are unique.

## solution

1. 题目意思是，把 arr 分成几个部分，每个部分分别 sort，和在一起正好组成一个 sorted array。
   return the max trunk size
2. 相当于在 arr 中划线，找到下一个部分 sort 的点：

创建一个 max array：int[] max，keep track of the max value until the current position,
划线的标准是，max[i]正好等于 sorted arr 中他应该等于的数字

```
original: 0, 2, 1, 4, 3, 5, 7, 6
max:      0, 2, 2, 4, 4, 5, 7, 7
sorted:   0, 1, 2, 3, 4, 5, 6, 7
index:    0, 1, 2, 3, 4, 5, 6, 7
```

0 | 2, 1 | 4, 3 | 5 | 7, 6

## code

```java
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        int chunks = 0;

        for(int i=1; i<arr.length; i++){
            max[i] = Math.max(max[i-1], arr[i]);
        }

        for(int i=0; i<arr.length; i++){
            if(i==max[i])
                chunks++;
        }

        return chunks;
    }
}
```
