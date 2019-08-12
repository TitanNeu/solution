/**
 * 题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.*;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    //结果数组
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    //用链表模拟队列，存储奇数和偶数层节点，两个队列交替使用
    private LinkedList<TreeNode> oddQueue = new LinkedList<>();
    private LinkedList<TreeNode> evenQueue = new LinkedList<>();
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null)
            return res;
        oddQueue.add(pRoot);
        //暂存某一层节点值
        ArrayList<Integer> valArr = new ArrayList<>();
        
        while(!oddQueue.isEmpty() || !evenQueue.isEmpty()){
            //奇数层不是空的，说明此时奇数层出队列，偶数层进队列
            if(!oddQueue.isEmpty()){
                //层序遍历
                while(!oddQueue.isEmpty()){
                    //奇数层出对列
                    TreeNode tempNode = oddQueue.pollFirst();
                    valArr.add(tempNode.val);
                    //偶数层进队列
                    if(tempNode.left != null) evenQueue.add(tempNode.left);
                    if(tempNode.right != null) evenQueue.add(tempNode.right);
                }
                res.add(new ArrayList<Integer>(valArr));
                valArr.clear();
            } else {
                //层序遍历
                while(!evenQueue.isEmpty()){
                    //偶数层出对列
                    TreeNode tempNode = evenQueue.pollFirst();
                    valArr.add(tempNode.val);
                    //奇数层进队列
                    if(tempNode.left != null) oddQueue.add(tempNode.left);
                    if(tempNode.right != null) oddQueue.add(tempNode.right);
                }
                res.add(new ArrayList<Integer>(valArr));
                valArr.clear();
            }
            
            
        }
        return res;
        
        
                
    }
    
}