# 142. Linked List Cycle II


https://leetcode.com/problems/linked-list-cycle-ii/description/

## Solution
use slow and fast pointer
    if fast pointer meet slow pointer than there is a cycle in the linked list
    what is the index of the start of the cycle?
        when slow meets fast
        slow walked distanceSlow = k
        fast walked distanceFast = 2k
        fast walked x more circles in the linked list cycle compared to slow

    we need to return the starting point of the cycle
    how to get that starting point?
        we assume that the meet point of slow and fast is distance = m away from the starting point.
        then the distance between head and the starting point of the cycle = k-m
        nd we going forward from the meet point for distance k-m we will reach the starting point.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, p = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        while(p != slow) {
            p = p.next;
            slow = slow.next;
        }

        return slow;
    }
}
```