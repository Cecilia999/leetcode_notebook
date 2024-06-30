# 19. Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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

//思路：用两个距离相隔n的指针，当后面的指针到达list的终点的时候，前面的指针指向的就是要remove的那个node

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {

      ListNode newHead = new ListNode(0,head); //给了 ListNode(int val, ListNode next)这个function可以直接用
      ListNode pre = newHead, last = newHead;
      
      for(int i=0; i<n; i++){
          last = last.next;
      }
      
      while(last.next!=null){
          pre=pre.next;
          last=last.next;
      }
      
      //或者 pre.next = pre.next.next;
      ListNode temp = pre.next;
      pre.next = temp.next;
      
      return newHead.next;
  }
}
```