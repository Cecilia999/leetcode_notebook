//题意：合并k个有序链表
//思路：
//借助分治的思想，把 K 个有序链表两两合并即可。相当于是第 21 题的加强版。

// int mid = start + (end-start)/2;
// ListNode l1 = partition(list, start, mid);
// ListNode l2 = partition(list, mid+1, end);
// return mergeTwoLists(l1, l2);


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
        return partition(lists, 0, lists.length-1);
        
        
    }
    
    public ListNode partition(ListNode[] list, int start, int end){
        if(start==end)
            return list[start];
        if(start<end){
            int mid = start + (end-start)/2;
            ListNode l1 = partition(list, start, mid);
            ListNode l2 = partition(list, mid+1, end);
            return mergeTwoLists(l1, l2);
        }
        else 
            return null;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode pt = head;
        while(l1!=null && l2!=null){    
            ListNode cur = new ListNode();
            if(l1.val<=l2.val){
                cur.val = l1.val;
                l1=l1.next;
            }
            else{
                cur.val = l2.val;
                l2=l2.next;
            }
                          
            pt.next = cur;
            pt  = pt.next;   
        }
        
        if(l1!=null)
            pt.next=l1;
        else if(l2!=null)
            pt.next=l2;
        
        return head.next;
    }
}