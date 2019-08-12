/**
 * 题目描述
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
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
//选用Stack结合分层存储。可以很方便实现之字打印
public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    //存储奇数的Stack
    private Stack<TreeNode> oddStack = new Stack<>();
    //存储偶数的Stack
    private Stack<TreeNode> evenStack = new Stack<>();
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null)
            return res;
        oddStack.push(pRoot);
        ArrayList<Integer> tempArr = new ArrayList<>();
        while(!oddStack.isEmpty() || !evenStack.isEmpty()){
            //奇数层Stack不是空，奇数层Stack出栈
            if(!oddStack.isEmpty()){
                while(!oddStack.isEmpty()){
                    TreeNode tempNode = oddStack.pop();
                    //存储节点值
                    tempArr.add(tempNode.val);
                    //同时偶数层先左后右的顺序进栈，这样偶数层弹出的时候就是从后往前弹出
                    if(tempNode.left != null) evenStack.push(tempNode.left);
                    if(tempNode.right != null) evenStack.push(tempNode.right);
                }
                //将一层节点值存入结果
                res.add(new ArrayList<Integer>(tempArr));
                //暂存节点值的数组清空，准备下一层
                tempArr.clear();
                
            } else {
                while(!evenStack.isEmpty()){
                    TreeNode tempNode = evenStack.pop();
                    tempArr.add(tempNode.val);
                    //奇数层按照先右后左的方式进Stack，这样弹出的时候就是从前往后
                    if(tempNode.right != null) oddStack.push(tempNode.right);
                    if(tempNode.left != null) oddStack.push(tempNode.left);
                }
                res.add(new ArrayList<Integer>(tempArr));
                tempArr.clear();
            }
        }
        return res;
        
    }

}