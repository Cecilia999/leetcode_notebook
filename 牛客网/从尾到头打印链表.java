/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //递归都最后一个node开始print！！！
        if(listNode!=null)
            printLinkedList(listNode, list);
        return list;
    }
    
    private void printLinkedList(ListNode listNode, ArrayList<Integer> list){
        if(listNode.next!=null)
            printLinkedList(listNode.next, list);
        list.add(listNode.val);
    }
}