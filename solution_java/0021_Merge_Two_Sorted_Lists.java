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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //create a new Node list, use newHead to hold the new Node list head node.
        //use p as the pointer to iterator the whole node list.
        //create p1, p2 to iterate l1, l2 so that won't lost list1 and list2 head pointer.
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        ListNode p1 = list1, p2 = list2;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null) {
            p.next = p1;
        }

        if(p2 != null) {
            p.next = p2;
        }

        return newHead.next;
    }
}