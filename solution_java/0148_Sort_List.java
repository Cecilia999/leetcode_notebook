// 题目大意
// 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
// 进阶：
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

// 解题思路
// 用merge sort归并排序
// 用two pointer来吧linked list分成一半

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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode fast=head, slow=head, pre=null;
        
        // step1
        // cut the list to two halves
        // 把指向mid node 的pointer改为指向null
        while(fast!=null && fast.next!=null){
            pre=slow;
            fast=fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        
        // step2 sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        //merge l1 and l2
        return mergeList(l1, l2);
    }
    
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode sortedHead = new ListNode(0);
        ListNode sorted= sortedHead;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                sorted.next = l1;
                l1 = l1.next;
            } else{
                sorted.next = l2;
                l2 = l2.next;
            }
            sorted = sorted.next;    
        }
        
        if(l1!=null){
            sorted.next = l1;
        }
        if(l2!=null){
            sorted.next = l2;
        }
        return sortedHead.next;
    }
}