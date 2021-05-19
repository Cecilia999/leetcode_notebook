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
//思路，用head遍历整个linkedlist
//newhead先指向前面一个node然后指向当前的listnode
//head先指向当前的node然后指向下一个listnode
class Solution {
  public ListNode reverseList(ListNode head) {
      ListNode newHead = null;
      while(head!=null){
          ListNode next = head.next;
          head.next = newHead;
          newHead = head;
          head = next;        
      }
      
      return newHead;
  }
}