/**
 * 题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

 /*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            return pNode;
        //当节点有右子树
        if(pNode.right != null){
           if(pNode.right != null){
                //找出右子树的最左边的节点
                TreeLinkNode curNode = pNode.right;
                while(curNode != null && curNode.left != null){
                    curNode = curNode.left;
                }
                return curNode;
            } 
        }
        //当节点没有右子树情况下:
        //1。当时它是父节点的左孩子节点时候，下一个节点就是父节点;
        //2. 当当前节点是父节点右孩子节点，那就看它父节点的父节点，看它父节点是不是父节点的父节点的左孩子，如果是的话就返回父节点的父节点，不是的话接着这样找，
        //找到根的话就说明这个节点是最后一个应该遍历的，没有后续节点了
        
        //找出父节点
        TreeLinkNode parent = pNode.next;
        while(parent != null){
            //如果当前节点是它父节点的左字节点，则LVR下一个就是父节点
            if(pNode == parent.left)
                return parent;
            //否则将父节点作为pNode，再去看pNode的父节点。
            pNode = parent;
            parent = parent.next;
        }
        return null;
        
    }
}