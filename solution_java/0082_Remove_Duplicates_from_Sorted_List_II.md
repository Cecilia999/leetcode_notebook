# 82. Remove Duplicates from Sorted List II

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

## Solution

这道题是前文 链表的双指针技巧汇总 中讲的 83. 删除排序链表中的重复元素 的进阶版。如果只让你把多于的重复元素去掉，那么快慢指针可以搞定，但这道题要求你把存在重复的元素全都去掉，一个简单粗暴的解法就是借助像哈希表这样的数据结构记录哪些节点重复了，然后去掉它们。

不过这道题输入的链表是有序的，这意味着重复元素都靠在一起，其实不用额外的空间复杂度来辅助，用两个指针就可以达到去重的目的，只是细节有点多，直接结合代码的详细注释来看吧。

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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode slow = dummyHead, fast = head;

        while(fast != null) {
            //发现有重复
            if(fast.next != null && fast.next.val == fast.val) {
                while(fast.next != null && fast.next.val == fast.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                if(fast == null) {
                    slow.next = null;
                }
                //不确定下一个元素会不会有重复
            } else {
                //确定下一个元素没有重复才接在slow后面
                slow.next = fast;
                fast = fast.next;
                slow = slow.next;
            }
        }

        return dummyHead.next;
    }
}
```

以前的思路也可以

```java
/two pointer: cur & pre
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
```