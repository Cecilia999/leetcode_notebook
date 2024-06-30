# 23. Merge k Sorted Lists

https://leetcode.com/problems/merge-k-sorted-lists/description/

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        //The challenging aspect of this problem is how to get the minumium ListNode of all K linked list.
        //We can use Priority Queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode h1, ListNode h2) {
                return h1.val - h2.val; //ascending order
            }
        });
        //Alternatively, using a lambda expression
        //PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((h1, h2) -> h1.val - h2.val);

        //create a dummy head and a iterator
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //store each list head in the pq
        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
```