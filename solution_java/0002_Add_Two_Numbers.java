// 题目大意
// 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

// 输入：l1 = [2,4,3], l2 = [5,6,4]
// 输出：[7,0,8]
// 解释：342 + 465 = 807.

// 解题思路
// linked list 用两个list node, 一个pt用来gothrough整个list，一个res用来保存头部
// 用int carray来manage carry
// while(l1!=null || l2!=null || carry!=0)
// 注意l1,l2的更新

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode pt = res;

        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int val = (l1==null? 0:l1.val) + (l2==null? 0:l2.val) + carry;
            carry = val/10;
            val %= 10;

            ListNode newNode = new ListNode(val);
            pt.next = newNode;
            pt = pt.next;

            l1 = l1==null? null:l1.next;
            l2 = l2==null? null:l2.next;
        }

        return res.next;
    }
}