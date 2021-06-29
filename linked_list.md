# Linked List

### 通用思路：

巧妙的构造虚拟头结点。可以使遍历处理逻辑更加统一。  
灵活使用递归。构造递归条件，使用递归可以巧妙的解题。不过需要注意有些题目不能使用递归，因为递归深度太深会导致超时和栈溢出。

### 1. 链表区间逆序

- [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)：  
  [java](/solution_java/0206_Reverse_Linked_List.java)
- [从尾到头打印链表](https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):  
  [java](/牛客网/从尾到头打印链表.java)
- [92 Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/):  
  [java](/solution_java/0092_Reverse_Linked_List_II.java)

### 2. 链表寻找中间节点/链表寻找倒数第 n 个节点

_只需要一次遍历就可以得到答案。_
**!!two pointer!!**

- [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/):
  [java](/solution_java/0876_Middle_of_the_Linked_List.java)
- [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/):  
  [java](/solution_java/0019_Remove_Nth_Node_From_End_of_List.java)
- [链表中倒数最后 k 个结点](https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=13&&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):  
  [java](/牛客网/链表中倒数最后k个结点.java)

### 3. 删掉重复/指定节点

用两个指针 cur&pre，cur 用来判断节点，用 pre.next = ... 来删除节点

- [83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/):
  [java](/solution_java/0083_Remove_Duplicates_from_Sorted_List.java)
- [82. Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii):
  [java](/solution_java/0082_Remove_Duplicates_from_Sorted_List_II.java)
- [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/):
  [java](/solution_java/0203_Remove_Linked_List_Elements.java)

### 4. merge sorted list

- [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/):
  [java](/solution_java/0021_Merge_Two_Sorted_Lists.java)
- [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/);
  [java](/solution_java/0023_Merge_k_Sorted_Lists.java)

### 5. 判断链表是否存在环，如果有环，输出环的交叉点的下标；判断 2 个链表是否有交叉点，如果有交叉点，输出交叉点。第 141 题，第 142 题，第 160 题。

- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/):
  [java](/solution_java/0141_Linked_List_Cycle.java)
- [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/):
  [java](/solution_java/0160_Intersection_of_Two_Linked_Lists.java)
