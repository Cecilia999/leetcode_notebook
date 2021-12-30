# 547. Number of Provinces

## problem

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

## solution

类似 200. number of island
但是 dfs 不是只从四个方向 search

## code

```java
class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        visited = new boolean[isConnected.length];

        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, i);
                province++;
            }
        }

        return province;
    }

    public void dfs(int[][] isConnected, int i){
        for(int other=0; other<isConnected.length; other++){
            if(isConnected[i][other]==1 && !visited[other]){
                visited[other] = true;
                dfs(isConnected, other);
            }
        }
    }
}
```
