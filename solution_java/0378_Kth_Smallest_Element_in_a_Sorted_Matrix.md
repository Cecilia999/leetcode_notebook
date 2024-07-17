# 378. Kth Smallest Element in a Sorted Matrix

https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

## Solution

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //We can think this question as merge k sorted linked list and find the nth node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for(int i=0; i < matrix.length; i++) {
            int[] pair = {matrix[i][0], i, 0};
            pq.offer(pair);
        }

        int min = 0;

        while(!pq.isEmpty() && k > 0) {
            int[] pair = pq.poll();
            int value = pair[0];
            int row = pair[1];
            int index = pair[2];

            min = value;
            k--;

            //add next linked list node to the pq if it hasn't reached the end
            if(index < matrix[row].length - 1) {
                int[] nextPair = {matrix[row][index + 1], row, index + 1};
                pq.offer(nextPair);
            }
        }

        return min;
    }
}
```