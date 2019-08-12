/**
 * 题目描述
输入两个链表，找出它们的第一个公共结点。
 */

 /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
有以下几种情况
    1. 相交的时候
        a. 1比2长
        b. 2比1长
        c. 2和1一样长
    2. 不相交的时候
        a. 1比2长
        b. 2比1长
        c. 2和1一样长 
     
      
*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        int len1 = cntNode(pHead1);
        int len2 = cntNode(pHead2);
        //1和2的长度差
        int delta = len1 - len2; 
        
        ListNode p1 = pHead1, p2 = pHead2;
        
        //调整p1和p2指针,使得他们对齐后准备遍历链表
        for(int i = 0; i < Math.abs(delta); i++){
            if(delta > 0){
                p1 = p1.next;
            } else if(delta < 0){
                p2 = p2.next;
            }
        }
       
        //指针对齐之后再遍历，链表如果有交点，就肯定会在相交的时候立刻返回;如果是平行的,则同时遍历到链表各自的尾部为止
        while(p1 != null && p2 != null){
            if(p1 == p2){
                return p1;
            }
            else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
        
        
        
    }
    //计算链表的长度
    public int cntNode(ListNode pHead){
        if(pHead == null)
            return 0;
        ListNode curNode = pHead;
        int cnt = 0;
        while(curNode != null){
            ++cnt;
            curNode = curNode.next;
        }
        return cnt;
            
    }
}