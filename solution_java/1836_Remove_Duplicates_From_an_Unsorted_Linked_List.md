# 1836. Remove Duplicates From an Unsorted Linked List

https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/description/

## Solution

dummyHead + 快慢指针

```java
**
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode fast = head, slow = dummyHead; //slow = dummyHead can process head need to be removed case easier.
        HashMap<Integer, Integer> map = new HashMap<>();

        while(fast != null) {
            if(map.get(fast.val) == null) {
                map.put(fast.val, 0);
            }
            map.put(fast.val, map.get(fast.val) + 1); 
            fast = fast.next;
        }

        fast = head;
        while(fast != null) {
            while(fast != null && map.get(fast.val) > 1) {
                fast = fast.next;
            }
            slow.next = fast;

            //reach linked list end
            if(fast == null) {
                break;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return dummyHead.next;
    }
}
```