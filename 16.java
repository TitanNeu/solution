// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。


/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//非递归常规算法
class Solution2 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        //多余的一个辅助节点
        ListNode resHead = new ListNode(-1);
        //保存入口节点
        ListNode entrance = resHead;
        ListNode curNode1 = list1, curNode2 = list2;
        //模仿归并排序两个有序序列的归并
        while(curNode1 != null && curNode2 != null){
            if(curNode1.val < curNode2.val){
                resHead.next = curNode1;
                curNode1 = curNode1.next;
            } else {
                resHead.next = curNode2;
                curNode2 = curNode2.next;
            }
            resHead = resHead.next;
        }
        //链表1有剩余
        if(curNode1 != null){
            resHead.next = curNode1;
        }
        //链表2有剩余
        if(curNode2 != null){
            resHead.next = curNode2;
        }
        return entrance.next;
        
    }
}
//递归算法
public class Solution {
    
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        //记录本次生成的链表头
        ListNode head;
        
        //选值比较小的节点作为链表头，进行递归链接
        if(list1.val < list2.val){
            
            head = list1;
            head.next = Merge(list1.next,list2);
        } else{
            head = list2;
            head.next = Merge(list2.next, list1);
        }
        
        return head;
   }
}



