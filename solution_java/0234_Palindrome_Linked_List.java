// 题目大意
// 请判断一个链表是否为回文链表。

// 解题思路
// 用two pointer把链表拆分成两半
// reverse其中一半
// 对比两个链表是否相等

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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
    
        //step1: cut the list to two halves
        ListNode slow = head, fast = head, pre=null;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        //step2: reverse slow to fast
        ListNode reverseHead = reverseLinkedList(slow);
        
        //step3: compare two list
        while(reverseHead!=null && head!=null){
            if(reverseHead.val!=head.val)
                return false;
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode reverseLinkedList(ListNode head){
        ListNode newHead = null;
        
        while(head!=null){
            ListNode cur = head;
            head = head.next;
            cur.next = newHead;
            newHead = cur;
        }
        
        return newHead;
    }
}