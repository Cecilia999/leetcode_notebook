// 题目大意 #
// 判断链表是否有环，不能使用额外的空间。如果有环，输出环的起点指针，如果没有环，则输出空。

// 解题思路 #
// 这道题是第 141 题的加强版。在判断是否有环的基础上，还需要输出环的第一个点。

//链表有环，则pointer永远不会指向null

//Floyd's cycle detection algorithm 龟兔赛跑法
//两个pointer 一个每次移动一步，一个每次移动两步，当它们相遇说明有环

//判断环的原理。fast 指针一次都 2 步，slow 指针一次走 1 步。令链表 head 到环的一个点需要 x1 步，从环的第一个点到相遇点需要 x2 步，从环中相遇点回到环的第一个点需要 x3 步。那么环的总长度是 x2 + x3 步。

// fast 和 slow 会相遇，说明他们走的时间是相同的，可以知道他们走的路程有以下的关系：

// fast 的 t = (x1 + x2 + x3 + x2) / 2
// slow 的 t = (x1 + x2) / 1

// x1 + x2 + x3 + x2 = 2 * (x1 + x2)

// 所以 x1 = x3  即，两个pointer相遇的点到环起点的位置和链表起点到环起点的位置一样远
// 所以 2 个指针相遇以后，如果 slow 继续往前走，fast 指针回到起点 head，两者都每次走一步，那么必定会在环的起点相遇，相遇以后输出这个点即是结果。
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
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast=head;
        boolean isCycle = false;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow==fast){
                isCycle = true;
                break;
            }
        }
        
        if(!isCycle) return null;
        
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}