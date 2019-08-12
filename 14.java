/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *  */

 /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//两次遍历的做法
class Solution2 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
            return null;
        ListNode curNode = head;
        int len = cntLen(head);
        if(k > len)
            return null;
        //从1计数，cnt个节点，倒数第k个就是正数第len-k+1
        int cnt = len-k+1;
        //从第一个节点开始，到len-k+1个为止
        for(int i = 1; i < len-k+1; i++){
            curNode = curNode.next;            
        }
        return curNode;
        
            
    }
    
    public int cntLen(ListNode head){
        if(head == null)
            return 0;
        ListNode curNode = head;
        int len = 0;
        while(curNode != null){
            ++len;
            curNode = curNode.next;
        }
        return len;
    }
}

//一次遍历的做法
public class Solution{
    public ListNode FindKthToTail(ListNode head, int k){
        //k <= 0的情况必须判断
        if(head == null || k <= 0)
            return null;
        //p1在前，p2在后; p1从第一个点，先移动到链表正数第k位置
        //然后p1和p2同时移动，等到p2到达最后一个节点，p1所在的位置就是所求的位置
        ListNode p1 = head;
        ListNode p2 = head;
        //p1移动到第k的节点位置，从第一移动到第k需要k-1次
        for(int i = 1; i < k && p1 != null; i++){
            //链表长度小于k
            p1 = p1.next;
        }
        if(p1 == null){
            return null;
        }
        //将p1移动到链表的最后的节点
        while(p1 != null && p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}