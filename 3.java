/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
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
import java.util.*;
class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(listNode == null)
            return res;
        ListNode curNode = listNode;
        while(curNode != null){
            stack.push(curNode.val);
            curNode = curNode.next;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
        
        
    }
}
public class Solution {
    //反转链表，但是这道题没什么必要
    public ListNode ReverseLinkedList(ListNode list){
        ListNode oldHead = list, newHead = null, temp = null;
        while(oldHead != null){
            temp = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = temp;
        }
        return newHead;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ListNode reverseList = ReverseLinkedList(listNode);
        while(reverseList != null){
            arrlist.add(reverseList.val);
            reverseList = reverseList.next;
        }
        
        return arrlist;
    }
}