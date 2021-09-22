// 题目大意 #
// 判断链表是否有环，不能使用额外的空间。

//思路：two pointer
// 1.Use two pointers, walker and runner.
// 2.walker moves step by step. runner moves two steps at time.
// 3.if the Linked List has a cycle walker and runner will meet at some
// point.


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        
        ListNode walker = head, runner =head;
        
        //如果有一个linked list有cycle，will never reach null
        while(runner!=null && runner.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) //要先increment 不然walker==runner==head
                return true;
        }
        return false;
    }
}