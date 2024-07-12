# leetcode_notebook

## 数据结构

### 1. labuladong学习算法和刷题的框架思维：
https://labuladong.online/algo/essential-technique/abstraction-of-algorithm/

数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储）。

1. Arrays:
- Structure: Arrays consist of a fixed-size sequence of elements of the same type, stored in contiguous memory locations.
- Access Time: Arrays offer constant-time access O(1) to elements using an index.
- Operations: Insertion and deletion operations can be costly O(n) if they involve shifting elements.
- Downstream Uses: 
    - Dynamic Arrays (like ArrayList in Java or List in Python): These can resize themselves as needed.
    - Vectors: A synchronized, resizable array implementation of the List interface. It is similar to ArrayList but with thread-safety. Thread-safe dynamic arrays. ```Vector<Integer> vector = new Vector<>();```
    - Stack: A subclass of Vector that implements a last-in-first-out (LIFO) stack of elements. ```Stack<Integer> stack = new Stack<>();```
    - HashMap: Uses an array of linked lists (or arrays of buckets) to implement a hash table. ```HashMap<String, Integer> map = new HashMap<>();```
    - PriorityQueue: Implemented using a binary heap, which is based on arrays. ```PriorityQueue<Integer> pq = new PriorityQueue<>();```

2. Linked Lists:
- Structure: Linked lists consist of nodes where each node contains a data element and a reference (or link) to the next node in the sequence.
- Access Time: Linked lists offer sequential access O(n) to elements, meaning you need to traverse the list to reach an element.
- Operations: Insertion and deletion operations are more efficient O(1) if you have a reference to the node where the operation needs to be performed.
- Downstream Uses: 
    - Queue and Deque: Implementing queues (FIFO) and deques (double-ended queues). supporting FIFO and LIFO operations.
        ```Queue<Integer> queue = new LinkedList<>();```
        ```Deque<Integer> deque = new LinkedList<>();```
    - ConcurrentLinkedQueue: A thread-safe, unbounded, non-blocking FIFO queue based on linked nodes.
        ```ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>()```
    - HashSet and LinkedHashSet: HashSet can use a LinkedList to handle hash collisions (though usually, it uses arrays of buckets). LinkedHashSet maintains a linked list of entries to preserve insertion order; Collections of unique elements; maintaining insertion order.
        ```HashSet<Integer> hashSet = new HashSet<>();```
        ```LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();```




### 2. 双指针 - Linked List

1. use two pointer to iterate two sub linked list
    use dummy head to hold the head pointer

- [0021_Merge_Two_Sorted_Lists](solution_java/0021_Merge_Two_Sorted_Lists.java)
- [0086_Partition_List](solution_java/0086_Partition_List.md)

2. [二叉堆的基本原理](Binary_Heap.md)

- [0023_Merge_k_Sorted_Lists](solution_java/0023_Merge_k_Sorted_Lists.md)


3. slow and fast pointer 
    1. can be used to check if ther is a cycle in the linked list.
    2. can be used to retrieve the middle node of a given linked list.

- [0019_Remove_Nth_Node_From_End_of_List](solution_java/0019_Remove_Nth_Node_From_End_of_List.md)
- [1474_Delete_N_Nodes_After_M_Nodes_of_a_Linked_List](solution_java/1474_Delete_N_Nodes_After_M_Nodes_of_a_Linked_List.md)
- [0141_Linked_List_Cycle](solution_java/0141_Linked_List_Cycle.md)
- [0142_Linked_List_Cycle_II](solution_java/0142_Linked_List_Cycle_II.md)
- [0082_Remove_Duplicates_from_Sorted_List_II](solution_java/0082_Remove_Duplicates_from_Sorted_List_II.md)
- [1836_Remove_Duplicates_From_an_Unsorted_Linked_List](solution_java/1836_Remove_Duplicates_From_an_Unsorted_Linked_List.md)

4. 把一个linked list接在另一个linked list后面

- [0160_Intersection_of_Two_Linked_Lists](solution_java/0160_Intersection_of_Two_Linked_Lists.md)


## 算法技巧

### 1. [如何高效寻找素 - Prime Number）](https://labuladong.online/algo/frequency-interview/print-prime-number/#%E9%AB%98%E6%95%88%E5%AE%9E%E7%8E%B0-countprimes)

what is prime number？ - A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

A natural number is a positive integer (1, 2, 3, ...) commonly used for counting and ordering.

- [0204_Count_Primes](solution_java/0204_Count_Primes.md)

### 2. [丑数系列 - Ugly Number](https://labuladong.online/algo/frequency-interview/ugly-number-summary/)

what is ugly number? - An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5. These numbers are composed only of the primes 2, 3, and 5, and no other prime factors.

Examples:
- 6 is an ugly number because its prime factors are 2 and 3.
- 8 is an ugly number because its prime factor is only 2 (since 8 = 2 × 2 × 2).

The Fundamental Theorem of Arithmetic states that any natural number greater than 1 is either a prime number itself or can be decomposed into a product of prime numbers.
正整数唯一分解定理 - 任意一个大于 1 的自然数，要么它本身就是质数，要么它可以分解为若干质数的乘积。

-[0263_Ugly_Number](solution_java/0263_Ugly_Number.md)


============================================

| \#   | Title                                                                                                                                                                                 | Solution                                                                              | Difficulty |
| ---- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ---------- |
| 0215 | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)                                                                                     | [java](/solution_java/0215_Kth_Largest_Element_in_an_Array.java)                      | medium     |
| jz29 | [最小的 K 个数](https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&&tqId=11182&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)      | [java](/牛客网/最小的K个数.java)                                                      | 中等       |
| 0179 | [Largest Number](https://leetcode.com/problems/largest-number/)                                                                                                                       | [java](/solution_java/0179_Largest_Number.java)                                       | medium     |
| jz32 | [把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&&tqId=11185&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](/牛客网/把数组排成最小的数.java)                                               | 较难       |
| jz35 | [数组中的逆序对](https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&&tqId=11188&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)     | [java](/牛客网/JZ35_数组中的逆序对.java)                                              | 中等       |
| 0493 | [Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)                                                                                                                         | [java](/solution_java/0493_Reverse_Pairs.java)                                        | hard       |
| 0148 | [Sort List](https://leetcode.com/problems/sort-list/)                                                                                                                                 | [java](/solution_java/0148_Sort_List.java)                                            | medium     |
| 0969 | [Pancake Sorting](https://leetcode.com/problems/pancake-sorting/)                                                                                                                     | [java](/solution_java/0969_Pancake_Sorting.java)                                      | medium     |
| 0692 | [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)                                                                                                      | [java](/solution_java/0692_Top_K_Frequent_Words.java)                                 | medium     |
| 0937 | [Reorder Data in Log Files](https://leetcode.com/problems/reorder-data-in-log-files/)                                                                                                 | [java](/solution_java/0937_Reorder_Data_in_Log_Files.java)                            | easy       |
| 0973 | [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)                                                                                               | [java](/solution_java/0973_K_Closest_Points_to_Origin.md)                             | medium     |
| 0207 | [207. Course Schedule](https://leetcode.com/problems/course-schedule/)                                                                                                                | [java](/solution_java/0207_Course_Schedule.md)                                        | medium     |
| 0210 | [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)                                                                                                          | [java](/solution_java/0210_Course_Schedule_II.md)                                     | medium     |
| 0269 | [269. Alien Dictionary](https://blog.csdn.net/littlehaes/article/details/104192778)                                                                                                   | [java](/solution_java/0269_Alien_Dictionary_II.md)                                    | hard       |
| 1647 | [1647. Minimum Deletions to Make Character Frequencies Unique](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/)                                 | [java](/solution_java/1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique.md) | medium     |
| 1152 | [1152. Analyze User Website Visit Pattern](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/)                                                     | [java](/solution_java/1152_Analyze_User_Website_Visit_Pattern.md)                     | medium     |
| 0253 | [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)                                                     | [java](/solution_java/0235_Meeting_Rooms_II.md)                     | medium     |
**[README_old_version](README_OLD_VERSION.md)**
============================================