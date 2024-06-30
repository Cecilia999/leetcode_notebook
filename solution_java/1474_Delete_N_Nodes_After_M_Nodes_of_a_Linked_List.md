# 1474. Delete N Nodes After M Nodes of a Linked List

https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/description/

## Solution

two pointer
Let slow pointer walk first to hold first m nodes that we want to preserve in the linked list. ==> walk m-1 steps
THEN let the fast = slow, and fast pointer going forward by n steps
THEN slow.next = fast.next

Be cautious when slow is reaching the end of the linked list

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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode slow = head, fast = head;

        while(slow != null) {
            int keepCount = m-1, removeCount = n;

            while(slow.next != null && keepCount > 0) {
                slow = slow.next;
                keepCount--;
            }

            fast = slow;
            while(fast.next != null && removeCount > 0) {
                fast = fast.next;
                removeCount--;
            }

            if(fast.next == null) {
                slow.next = null;
                break;
            }

            slow.next = fast.next;
            slow = slow.next;
        }
        
        return head;
    }
}
```