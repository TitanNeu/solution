// 输入一个链表，反转链表后，输出新链表的表头。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode newHead = null;
        ListNode tempNode = null;
        ListNode oldHead = head;
        while(oldHead != null){
            tempNode = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = tempNode;
        }
        return newHead;

    }
}