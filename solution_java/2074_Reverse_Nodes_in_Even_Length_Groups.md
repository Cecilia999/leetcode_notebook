# 2074. Reverse Nodes in Even Length Groups

## problem

You are given the head of a linked list.

The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,

The 1st node is assigned to the first group.
The 2nd and the 3rd nodes are assigned to the second group.
The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.

Reverse the nodes in each group with an even length, and return the head of the modified linked list.

Example 1:

Input: head = [5,2,6,3,9,1,7,3,8,4]
Output: [5,6,2,3,9,1,4,8,3,7]
Explanation:

- The length of the first group is 1, which is odd, hence no reversal occurs.
- The length of the second group is 2, which is even, hence the nodes are reversed.
- The length of the third group is 3, which is odd, hence no reversal occurs.
- The length of the last group is 4, which is even, hence the nodes are reversed.
  Example 2:

Input: head = [1,1,0,6]
Output: [1,0,1,6]
Explanation:

- The length of the first group is 1. No reversal occurs.
- The length of the second group is 2. The nodes are reversed.
- The length of the last group is 1. No reversal occurs.
  Example 3:

Input: head = [1,1,0,6,5]
Output: [1,0,1,5,6]
Explanation:

- The length of the first group is 1. No reversal occurs.
- The length of the second group is 2. The nodes are reversed.
- The length of the last group is 2. The nodes are reversed.

Constraints:

The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 10^5

## solution

1. 和 25 题差不多，但是只有区间长度为偶数的 group 需要 reverse
2. 需要分奇偶处理，偶数情况和 25 题一样，奇数的情况需要一个新的 pointer：prevNextHeader,直接连接 nexthead

## code

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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        return reverseKLengthGroups(head, 1);
    }

    public ListNode reverseKLengthGroups(ListNode head, int k){
        //kth node，k+1th node
        ListNode prevNextHead = head, nextHead = head;
        int count = 0;

        while(nextHead!=null && count!=k){
            prevNextHead = nextHead;
            nextHead = nextHead.next;
            count++;
        }

        if(nextHead!=null)
            nextHead = reverseKLengthGroups(nextHead, k+1);

        //even solve like leetcode25
        if(count%2==0){
            while(count>0){
                ListNode next = head.next;
                head.next = nextHead;
                nextHead = head;
                head = next;
                count--;
            }
            head = nextHead;
            return head;
        }
        //odd, prevNextHead connect to nextHead directly
        else{
            prevNextHead.next = nextHead;
            return head;
        }
    }
}
```
