# 646. Maximum Length of Pair Chain

## problem description

You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

Example 1:

Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].

Example 2:

Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].

Constraints:

n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti <= 1000

## solution

greedy

1. if pair1[1]<pair2[0] choose pair1
2. if pair1[1]>=pair2[0]

1) if pair1[1]<pair2[1] choose pair1
2) else choose pair2
   since choose pair1/2 would increment the total length by one
   we should choose the one with min(pair1[1], pair2[1])

## code

```java
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2)->{
            if(o1[1]==o2[1])
                return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        int count = 0, i = 0, n = pairs.length;

        while(i<n){
            count++;
            int curEnd = pairs[i][1];

            //skip起点小于curEnd的所有interval
            while(i<n && pairs[i][0]<=curEnd) i++;
        }

        return count;
    }
}
```
