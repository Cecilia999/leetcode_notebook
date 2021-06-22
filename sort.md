# Sort

![Alt text](/images/排序bigo.jpg)
![Alt text](/images/排序分类.jpg)

- 冒泡排序：是相邻两个数比较然后如果 arr[j-1]>arr[j]就把 arr[j-1]往后移
- 选择排序：是把对比整个 array 把最小的放在最前面，然后对比整个 array 把第二小的放在第二的位置
- 插入排序：是如果 j-1 位置的值比 target 值要大，就把当前位置=j-1 位置的值，j--。只要 j>0 且满足这个条件就一直 loop，逻辑是把 target 值放到他合适的位置

### 1. quick sort 快速排序

快速排序采用分治+递归，每次将一个位置上的数据归位，此时该数左边的所有数据都比该数小，右边所有的数据都比该数大，然后递归将已归位的数据左右两边再次进行快排，从而实现所有数据的归位。  
**完全倒序的情况下是最慢的 O(n^2)**

1. find kth largest/ kth smallest

- [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/):  
  [java](/solution_java/0215_Kth_Largest_Element_in_an_Array.java)

- [最小的 K 个数](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0215.Kth-Largest-Element-in-an-Array/)  
  [java](/牛客网/最小的K个数.java)

2. concat int to string override array.sort()

- [179. Largest Number](https://leetcode.com/problems/largest-number/):
  [java](/solution_java/0179_Largest_Number.java)

### 参考

- 快速排序：https://www.cnblogs.com/anthonyhoo/p/12259543.html
- 几种排序算法的总结与比较：https://www.jianshu.com/p/7df9d6206e72
