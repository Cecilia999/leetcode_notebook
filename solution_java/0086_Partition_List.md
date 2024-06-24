# 86. Partition List

https://leetcode.com/problems/partition-list/description/

## Solution
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
    public ListNode partition(ListNode head, int x) {
        //Create dummy1 to hold head for linked list to store node < x
        ListNode dummy1 = new ListNode(-1);
        //Create dummy2 to hold head for linked list to store node >= x
        ListNode dummy2 = new ListNode(-2);
        //p1, p2 to traverse two linked list
        ListNode p1 = dummy1, p2 = dummy2;
        //p to traverse input linked list
        ListNode p = head;

        while(p != null) {
            if(p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            //p could not directly = p.next, it will cause linked list cycle
            // we need to break the link between p and p.next
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        //link 2 linked list
        p1.next = dummy2.next;

        return dummy1.next;
    }
}
```