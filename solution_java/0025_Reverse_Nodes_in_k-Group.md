# 25. Reverse Nodes in k-Group

## problem

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000

## solution

ListNode + recursion 或者 two nested loop

## code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //head.val = 1;
        ListNode cur = head;
        int count = 0;

        while(cur!=null && count!=k){
            cur = cur.next; //move cur to node k+1
            count++;
        }

        if(count == k){
            cur = reverseKGroup(cur, k); //let cur become the new head of next reordered part
            while(count>0){
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
                count--;
            }
            head = cur; //cur 始终指向翻转过程中new insert的head
        }

        return head;
    }
}
```
