/*题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。*/

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null)
            return null;
        ListNode slow = pHead; //慢指针
        ListNode quick = pHead; //快指针
        
        //如果链表是个环，循环中但是慢指针和快指针总会相遇
        while(quick != null && quick.next != null){ 
            //先移动再判断
            slow = slow.next;
            quick = quick.next.next;
            //当在环中慢指针和快指针相遇后，跳出
            if(slow == quick)
                break;
        }
        //判断循环退出是不是由于快指针到了链表尾部，如果是，则说明链表无环
        if(quick == null || quick.next == null) 
            return null;
        //有环。将slow放到链表头，slow和quick步进都变成1，相遇的地方就是链表环的入口
        slow = pHead;
        while(slow != quick){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}