# Sort

![Alt text](/images/排序分类.jpg)
![Alt text](/images/sort_algorithm_cheatsheet.jpg)

- 冒泡排序：是相邻两个数比较然后如果 arr[j-1]>arr[j]就把 arr[j-1]往后移
- 选择排序：是把对比整个 array 把最小的放在最前面，然后对比整个 array 把第二小的放在第二的位置
- 插入排序：是如果 j-1 位置的值比 target 值要大，就把当前位置=j-1 位置的值，j--。只要 j>0 且满足这个条件就一直 loop，逻辑是把 target 值放到他合适的位置

**参考**

- https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
- https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/

## 1. quick sort 快速排序

快速排序采用分治+递归，每次将一个位置上的数据归位，此时该数左边的所有数据都比该数小，右边所有的数据都比该数大，然后递归将已归位的数据左右两边再次进行快排，从而实现所有数据的归位。  
**完全倒序的情况下是最慢的 O(n^2)**

```java
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end){
        if(start>=end)
            return;

        int pivot = start, l=start, r=end;

        while(l<r){

            while(nums[r]>=nums[pivot] && l<r)
                r--;
            while(nums[l]<=nums[pivot] && l<r)
                l++;

            //把nums[r]和nums[l]互换位置
            if(l<r){
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
            }

        }

        //把nums[l]和pivot互换位置
        int temp = nums[pivot];
        nums[pivot] = nums[l];
        nums[l] = temp;

        quickSort(nums, start, l-1);
        quickSort(nums, l+1, end);
    }

}
```

**第二种写法, find kth element/sort first k**

```java
public int[] sortArray(int[] nums, int k) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = helper(nums, l, r);
        if (mid == k) break;
        if (mid < K) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
}

private int helper(int[] nums, int l, int r) {
    int pivot = nums[l];
    while (l < r) {
        while (l < r && nums[r]>=pivot) r--;
        nums[l] = nums[r];
        while (l < r && nums[l]<=pivot) l++;
        nums[r] = nums[l];
    }
    nums[l] = pivot;
    return l;
}
```

### 1.1 find kth largest/ kth smallest

- [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/):  
  [java](/solution_java/0215_Kth_Largest_Element_in_an_Array.java)
- [215. 最小的 K 个数](https://books.halfrost.com/leetcode/ChapterFour/0200~0299/0215.Kth-Largest-Element-in-an-Array/)  
  [java](/牛客网/最小的K个数.java)
- [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/):
  [java](/solution_java/0973_K_Closest_Points_to_Origin.md)

### 1.2 多路快排

- [75. Sort Colors](https://leetcode.com/problems/sort-colors/):
  [java](/solution_java/0075_Sort_Colors.java)

## 2. Merge Sort 归并排序

归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。

![alt text](/images/merge_sort1.jpg)
![alt text](/images/merge_sort2.jpg)

可以看到这种结构很像一棵完全二叉树，本文的归并排序我们采用递归去实现（也可采用迭代的方式去实现）。  
分阶段可以理解为就是递归拆分子序列的过程，递归深度为 log2n。
治阶段，我们需要将两个已经有序的子序列合并成一个有序序列，比如上图中的最后一次合并，要将[4,5,7,8]和[1,2,3,6]两个已经有序的子序列，合并为最终序列[1,2,3,4,5,6,7,8], 需要用到辅助空间，辅助空间的 bigo 为 O(n)

```java
public class mergeSort {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr){
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    //递归
    public static void sort(int[] arr, int left, int right, int[] temp){
        if(left<right){ //left>=right的时候停止sort，即最小分治单位是两个数字
            int mid = left + (right - left)/2;

            sort(arr, left, mid, temp); //左边归并排序，使得左子序列有序
            sort(arr, mid+1, right, temp); //右边归并排序，使得右子序列有序

            merge(arr, left, mid, right, temp); //将两个有序子数组合并操作
        }
    }

    //merge的逻辑是把left-mid 和mid+1-right两个部分，先比较大小，再按顺序放入temp，最后copy到arr
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){

        int i=left, j=mid+1, k=0;
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid){//将左边剩余元素填充进temp中
            temp[k++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = arr[j++];
        }

        //将temp中的元素全部拷贝到原数组中
        //注意！！这里只copy left-right这一小段，不是copy整个arr！！！
        k=0;
        while(left<=right){
            arr[left++] = temp[k++];
        }
    }
}
```

归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。java 中 Arrays.sort()采用了一种名为 TimSort 的排序算法，就是归并排序的优化版本。从上文的图中可看出，每次合并操作的平均时间复杂度为 O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为 O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为 O(nlogn)。

### 2.1 数组的 merge sort

- [数组中的逆序对](https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&&tqId=11188&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):
  [java](/牛客网/JZ35_数组中的逆序对.java)
- [493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/):
  [java](/solution_java/0493_Reverse_Pairs.java)  
   参考：https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22

### 2.2 linked list 链表的 merge sort

- [148. Sort List](https://leetcode.com/problems/sort-list/):
  [java](/solution_java/0148_Sort_List.java)

## 3. Override compare() in Arrays.sort()

- [179. Largest Number](https://leetcode.com/problems/largest-number/):
  [java](/solution_java/0179_Largest_Number.java)
- [jz32. 把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&&tqId=11185&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):
  [java](/牛客网/把数组排成最小的数.java)
- [937. Reorder Data in Log Files](https://leetcode.com/problems/reorder-data-in-log-files/):
  [java](/solution_java/0937_Reorder_Data_in_Log_Files.java)
- [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/):
  [java](/solution_java/0973_K_Closest_Points_to_Origin.md)

## 4. 优先队列

定义优先队列

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
    @Override
    public int compare(Integer i1,Integer i2){
        return i2-i1;
    }
});

```

- [253. Meeting Room](/solution_java/0253_meeting_room.java)
- [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/):
  [java](/solution_java/0692_Top_K_Frequent_Words.java)
- [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/):
  [java](/solution_java/0973_K_Closest_Points_to_Origin.md)

## 5. 煎饼排序

- [969. Pancake Sorting](https://leetcode.com/problems/pancake-sorting/):
  [java](/solution_java/0969_Pancake_Sorting.java)

## 6. Topological Sort

1. 什么是拓扑排序
   对一个**有向无环图(Directed Acyclic Graph 简称 DAG)** G 进行拓扑排序，是将 G 中所有顶点排成一个线性序列，使得图中任意一对顶点 u 和 v，若边(u,v)∈E(G)，则 u 在线性序列中出现在 v 之前。通常，这样的线性序列称为满足拓扑次序(Topological Order)的序列，简称拓扑序列。简单的说，由某个集合上的一个偏序得到该集合上的一个全序，这个操作称之为拓扑排序。 无向图和有环的有向图没有拓扑排序
2. 拓扑排序的步骤：
   1. 构建图，用 list<> / hashmap<>, 把箭头的指向关系给构建好
   2. 根据 1 构建的图，计算 indegree[]
   3. 把 indegree[]==0 的 node 加入 queue
   4. 删掉 indegree[]==0 的 node，decrease 所有相邻点的 indegree，把 indegree[]==0 的相邻点加入 queue
   5. 循环
   6. 判断是否有环

![alt text](../image/topological_sort.jpg)

- [207. Course Schedule](https://leetcode.com/problems/course-schedule/):
  [java](/solution_java/0207_Course_Schedule.md)
- [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/):
  [java](/solution_java/0210_Course_Schedule_II.md)
- [269. Alien Dictionary](https://blog.csdn.net/littlehaes/article/details/104192778):
  [java](/solution_java/0269_Alien_Dictionary_II.md)

## 7. hashset

- [1647. Minimum Deletions to Make Character Frequencies Unique](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/):
  [java](/solution_java/1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique.md)

## 参考

- 快速排序：https://www.cnblogs.com/anthonyhoo/p/12259543.html
- 几种排序算法的总结与比较：https://www.jianshu.com/p/7df9d6206e72
- 归并排序：https://www.cnblogs.com/chengxiao/p/6194356.html
