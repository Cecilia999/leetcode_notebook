# 907. Sum of Subarray Minimums

## problem

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444

Constraints:

1 <= arr.length <= 3 _ 104
1 <= arr[i] <= 3 _ 104

## solution

- instead of find all subarray and then find the minimum of the subarray
- we can think inversely which is, for each minimum, find how many subarray it belongs to
- 找到比当前这个 element 小的左边界，store in previsouLess[]
- 找到比当前这个 element 小的右边界，store in nextLess[]
- 用 **monotonic stack** to find PLE & NLE
- Previsous Less Element & Next Less Element

## code

```java
class Solution {
//O(n^2) time limit exceed
//     public int sumSubarrayMins(int[] arr) {
//         int sum = 0, n = arr.length;

//         for(int i=0; i<n; i++){
//             int min=arr[i];
//             for(int j=i; j<n; j++){
//                 min = Math.min(min, arr[j]);
//                 //System.out.println("min:"  + min + " arr[j]:" + arr[j]);
//                 sum += min;
//                 sum %= 1000000007;
//             }
//         }

//         return sum;
//     }

    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n=arr.length, mod =(int) 1e9+7;
        int[] previousLess = new int[n], nextLess  = new int[n];

        //没有next smaller or previous smaller的
        Arrays.fill(previousLess, -1);
        Arrays.fill(nextLess, n);

        //NLE模版
        Stack<Integer> stack1 = new Stack<>();  //stack这里存的是index，也可以存int[]
        for(int i=0; i<n; i++){
            while(!stack1.isEmpty() && arr[stack1.peek()] > arr[i]){
                nextLess[stack1.pop()] = i;
            }
            stack1.push(i);
        }

        //PLE模版
        Stack<Integer> stack2 = new Stack<>();  //stack这里存的是index，也可以存int[]
        for(int i=n-1; i>=0; i--){
            //arr[stack2.peek()] >= arr[i] 这里是>= 非常重要！！！！！
            //如果区间有两个相同的最小值，只取一个
            while(!stack2.isEmpty() && arr[stack2.peek()] >= arr[i]){
                previousLess[stack2.pop()] = i;
            }
            stack2.push(i);
        }

        for(int i=0; i<n; i++){
            int left = previousLess[i], right = nextLess[i];
            sum = (sum + (long)arr[i] * (i-left) * (right-i))  % mod;
        }

        return (int)sum;
    }
}
```
