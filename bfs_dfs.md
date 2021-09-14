# BFS & DFS

matrix search with BFS & DFS 的小 tips 是用

```java
private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
```

来实现 bfs/dfs

## BFS

### 1. 双向 bfs using hashset

- [127. Word Ladder](https://leetcode.com/problems/word-ladder/):
  [java](/solution_java/0127_Word_Ladder.java)
- [752. Open the Lock](https://leetcode.com/problems/open-the-lock/):
  [java](/solution_java/0752_Open_the_Lock.java)

### 2. 单向 bfs matrix search + queue

- [542. 01 Matrix](https://leetcode.com/problems/01-matrix/):
  [java](/solution_java/0542_01_Matrix.java)
- [1162. As Far from Land as Possible](https://leetcode.com/problems/as-far-from-land-as-possible/) | [java](/solution_java/1162_As_Far_from_Land_as_Possible.java)

### 3. matrix bfs with 障碍物

- [机器人的运动范围](https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):
  [java](/牛客网/机器人的运动范围.java)

## DFS

### 1. matrix dfs 搜索一串单词/一条路径

- [200. Number of Islands](https://leetcode.com/problems/number-of-islands/):
  [java](/solution_java/0200_Number_of_Islands.java)
- [79. Word Search](https://leetcode.com/problems/word-search/):
  [java](/solution_java/0079_Word_Search.java)

## bfs + dfs

- [126. Word Ladder II](https://leetcode.com/problems/word-ladder-ii/):
  [java](/solution_java/0126_Word_Ladder_II.java)
