# 370. Range Addition

## problem

You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].

You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.

Return arr after applying all the updates.

Example 1:

Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]
Example 2:

Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
Output: [0,-4,2,2,2,4,4,-4,-4,-4]

Constraints:

1 <= length <= 105
0 <= updates.length <= 104
0 <= startIdxi <= endIdxi < length
-1000 <= inci <= 1000

## solution

1. 第一个想出来的方法是 O(k\*n), 先 initialize an array of 0 with given length, 然后 loop update 来 apply updation to arr

2. 尝试优化的思路，用 prefix sum 能够得到 O(k+n)的解法，每次 update 只需要改变 start 和 end+1 处，然后 prefix sum

## code

```java
//O(k+n)
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for(int i=0; i<updates.length; i++){
            int start = updates[i][0], end = updates[i][1], inc = updates[i][2];
            arr[start] += inc;
            if(end < arr.length-1)
            arr[end+1] -= inc;
        }

        for(int i=1; i<arr.length; i++)
            arr[i] += arr[i-1];

        return arr;
    }
}

//O(k*n)
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //1. initialize an array with given length filled in 0
        int[] arr = new int[length];

        //2. use for loop to apply updates to arr
        for(int i=0; i<updates.length; i++){
            int start = updates[i][0], end = updates[i][1], inc = updates[i][2];
            for(; start<=end; start++)
                arr[start] += inc;
        }

        return arr;
    }
}
```
