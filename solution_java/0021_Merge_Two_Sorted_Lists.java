//题意：merge两个有序链表使其变成一个有序链表
//思路：
//每次创建一个node，l1,l2哪个当前值大就把node的值assign给谁
//然后在总链表中插入node

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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode sortlist = new ListNode(0);
      ListNode node = sortlist;
      
      while(l1!=null && l2!=null){
          ListNode temp = new ListNode(l1.val);
          if(l1.val<=l2.val){
              temp.val=l1.val;
              l1=l1.next;
          }
          else{
             temp.val=l2.val;
              l2=l2.next;
          }
          node.next=temp;
          node=node.next;            
      }
      
      if(l1!=null)
          node.next=l1;
      else if(l2!=null)
          node.next=l2;
      return sortlist.next;
  }
}