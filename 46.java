/**
 * 题目描述
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,
今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。

其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */


//利用了数学推导的办法，约瑟夫环的问题

import java.util.*;
class Solution2 {
    //n代表总人数，m代表一轮要报数的人
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0)
            return -1;
        ArrayList<Integer> children = new ArrayList<>();
        for(int i = 0; i < n; i++){
            children.add(i);
        }
        int pre = -1; //初始化指向最开始报数的人的前面位置的索引，由于开始编号第一个是0。所以前面是-1
        while(children.size() > 1){
            int target = (pre+m)%(children.size()); //利用公式找到每一轮最后一个报数的索引
            children.remove(target);
            pre = --target; //将指针指向新一轮报数的人的前面,准备再次使用公式
        }
        return children.get(0);
        
    }
}


/*利用了环链表模拟，常规思路*/

class LinkNode{
    int val;
    LinkNode next;
    public LinkNode(int val){
        this.val = val;
    }
       
}
public class Solution {
    
    public LinkNode createCircle(int n){ //创建节点数目为n的环
        LinkNode head = new LinkNode(0);
        LinkNode pCur = head;//当前节点指针初始化为链表头
        for(int i = 1; i < n; i++){ //后面挂n-1节点，构成一个n节点的单向链表
            LinkNode tempNode = new LinkNode(i);
            pCur.next = tempNode;
            pCur = tempNode;            
        }
        //形成环
        pCur.next = head;
        
        return head;
               
    }
    public int LastRemaining_Solution(int n, int m) {
        if(m == 0 || n == 0)
            return -1;
        //建立一个n个节点的链表环
        LinkNode head = createCircle(n);
        //前驱节点
        LinkNode pre = new LinkNode(-1);
        //当前节点
        LinkNode pCur = head;
        while(pCur.next != pCur){
            //移动pre指针，指向被删除人的前面位置
            for(int i = 0; i < m-1; i++){ //从0报数，枪毙报m-1的人，等价与从1 报数，枪毙报m的人。
                //报数m次，执行循环m-1次，当退出循环时，pCur指向要枪毙的人
                pre = pCur;
                pCur = pCur.next;
            }
            pre.next = pCur.next;
            pCur.next = null;
            pCur = pre.next;
            
        }
        return pCur.val;
    } 
    
}


