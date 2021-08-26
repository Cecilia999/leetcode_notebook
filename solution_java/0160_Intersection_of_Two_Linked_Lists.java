//题目大意：
//找出两个链表的第一个公共节点
//思路：
//给定的 2 个链表的长度如果一样长，都从头往后扫即可。
//如果不一样长，需要先“拼成”一样长。把 B 拼接到 A 后面，把 A 拼接到 B 后面。这样 2 个链表的长度都是 A + B。
//再依次扫描比较 2 个链表的结点是否相同。

//e.g.
//head1: a1->a2->c1->c2->c3
//head2: b1->b2->b3->c1->c2->c3

//拼在一起
// head1: a1->a2->c1->c2->c3->b1->b2->b3-> c1 ->c2->c3
// head2: b1->b2->b3->c1->c2->c3->a1->a2-> c1- >c2->c3
// 第一个common node c1

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode p1=headA, p2=headB;
      
      while(p1!=p2){
          //p1, p2 会在同时==null然后退出循环
          p1= p1==null? headB : p1.next;
          p2= p2==null? headA : p2.next;
      }
      
      return p1;
  }
}