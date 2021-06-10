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

//思路
//216题的加强版，先找到left的前一个node = pre
//然后标记start=pre.next, then=start.next
// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3

//然后在right-left的区间交换node
//reverse的逻辑是：
//把then指向的node插入刀pre和pre.next之间，保持剩下的部分顺序不变
//then update到当前要插入的node，which is start.next
//start.next要保持连接到then.next因为then要插入到pre和pre.next之间，会lose track

class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
      if(head==null) return null;
      
      //head就是node1，应该create a dummy node point to head
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      
      ListNode pre=dummy;
      for(int i=0; i<left-1; i++)
          pre=pre.next;
      
      ListNode start=pre.next;
      ListNode then=start.next;
      
      for(int i=0; i<right-left;i++){
          start.next=then.next;
          then.next=pre.next;
          pre.next=then;
          then=start.next;
      }
      
      
      // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
      // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
      
      return dummy.next;
  }
}