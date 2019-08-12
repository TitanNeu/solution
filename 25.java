/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        //建立旧新交替的链表
        RandomListNode curNode = pHead;
       
        while(curNode != null){
            RandomListNode copyNode = new RandomListNode(curNode.label);
            copyNode.next = curNode.next;
            curNode.next = copyNode;
            curNode = copyNode.next;
        }
        //建立新节点中的随机指向, 每一个curNode后面都有一个它的副本
        curNode = pHead;
        while(curNode != null){
            //这里别忘了判断，不然会null pointer exception
            if(curNode.random != null){
                //老节点的随机指针指向老节点，新节点的随机指针指向对应老节点的新节点，所以是curNode.random.next
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
        
        //分离新旧链表,分离过程中，老链表末尾节点，需要在新链表末尾节点后面一个节点，才能保证分离正常进行
        
        //老链表头
        RandomListNode oldHead = pHead;
        //新链表头
        RandomListNode newHead = pHead.next;
        //链接旧链表的前两个节点，并把当前旧链表节点更新为第二个节点
        oldHead.next = newHead.next;
        //当前指向的旧链表节点
        RandomListNode curOldNode = oldHead.next;
        //当前指向的新链表节点
        RandomListNode curNewNode = newHead;

        while(curOldNode != null){
            //链接新链表
            curNewNode.next = curOldNode.next;
            //更新新链表最后节点
            curNewNode = curNewNode.next;            
            //链接旧链表
            curOldNode.next = curNewNode.next;            
            //更新旧链表最后节点
            curOldNode = curOldNode.next;
            
        }
        return newHead;
        /*简便办法，但是会使得原始链表消失
        //旧新旧新排布的链表。
        curNode = pHead;
        RandomListNode in = pHead.next, curHead = pHead.next;
        
        while(curHead != null && curHead.next != null && curHead.next.next != null){
            curHead.next = curHead.next.next;
            curHead = curHead.next;
        }
        //将新链表与原始链表断开;
        pHead.next = null;
        return in;
        */
    }
}