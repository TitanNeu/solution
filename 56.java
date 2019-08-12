/**
 * 题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

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
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) //空链或者一个节点的情景
            return pHead;
        ListNode preNode = new ListNode(-1); //前驱节点
        ListNode storePreNode = preNode; //保存最初的前驱节点的指针
        ListNode curNode = pHead; //当前节点       
        preNode.next = pHead;
        
        while(curNode != null){
            ListNode tempNode = curNode.next;
            if(tempNode == null) break;
            if(tempNode.val == curNode.val){ 
                while((tempNode != null) && (tempNode.val == curNode.val)){
                    tempNode = tempNode.next;
                }
                preNode.next = tempNode;
                curNode = tempNode;
            } else if(tempNode.val != curNode.val){               
                preNode = curNode;
                curNode = tempNode;
            }
        }
        return storePreNode.next;
        
        
    }
}

/*
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
                 
        if (pHead == null) return null;
        ListNode p = pHead;
        ListNode n = new ListNode(0);
        ListNode pre = n;
        n.next = pHead;
        boolean flag = false;
        while (p != null) {
            ListNode q = p.next;
            if (q == null) break;
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
            } else {
                if (!flag) { //将自己创建的前驱节点指向第一个不重复的节点，只会执行一次
                    n.next = p;
                    flag = true;
                }
                pre = p;
                p = q;
            }
        }
        return n.next;
    }
}
*/
