# 160. Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/description/

## Solution

 思路：
 要么是用空间换时间，用一个hashset来记录一条linked list的值然后进行一次traverse比较找出交点
 如果不用额外的空间，仅仅用两个pointers如何找出交点？
 难点在于两个linked list不一样长，所以我们要将两个linked list变得一样长
 让pointer1先遍历linkedlistA然后遍历linkedlistB
 pointer2先遍历linkedlistB然后遍历linkedlistA
 逻辑上把两个linkedlist互相接在他们对方的后面这样他们就一样长了。
 此过程中他们相同的点就是相交的点
 或者他们会同时 == null

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if(p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
```