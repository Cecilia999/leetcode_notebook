//two pointer: cur & pre
//edge case = [1,1,2,3,4,4,5,5,5]


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
      if(head == null) return null;
      //老规矩创造一个newhead指向head,以防head会被删除
      ListNode newHead = new ListNode(0, head);
      ListNode cur = head;
      
      ListNode pre = newHead;
      
      while(cur!=null){
          while(cur.next!=null && cur.val == cur.next.val){
              cur = cur.next;
          }
          
          //正常的顺序来说，pre.next = cur
          //只有当遇到dup nodes，cur会直接移动到最后一个dup nodes，这个时候pre.next！=cur
          //pre.next需要指向cur.next才能删掉所有的dup nodes
          if(pre.next==cur)
              pre = pre.next;
          else
              pre.next = cur.next;
          
          cur = cur.next;
      }
      
      return newHead.next;
  }
}