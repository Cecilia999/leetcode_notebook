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
  public ListNode deleteDuplicates(ListNode head) {
      if(head==null) return null;
      
      //老规矩创造一个newhead指向head，以防head会被删除
      ListNode newHead = new ListNode(0, head);
      
      while(head.next!=null){
          if(head.next.val==head.val)
              head.next = head.next.next;    
          //！！
          else
              head = head.next;
      }
      
      return newHead.next;
  }
}