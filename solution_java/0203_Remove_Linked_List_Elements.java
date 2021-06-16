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
  public ListNode removeElements(ListNode head, int val) {
      if(head == null) return null;
      //创造一个newhead指向head，以防head会被删除
      ListNode newHead =  new ListNode(0, head);
      ListNode cur = head;
      ListNode pre = newHead;
      
      while(cur!=null){
          if(cur.val == val){
              pre.next = cur.next;
              cur = cur.next;
          }
          else{
              cur = cur.next;
              pre = pre.next;
          }                
      }
      
      return newHead.next;
  }
}