/**
 * 题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
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


//利用非空BST中序遍历之后是一个节点值从小到大的节点数组的特性。
public class Solution {
    private ArrayList<TreeNode> numsArr = new ArrayList<>(); //存储遍历节点的数组
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0)
            return null;
        //递归中序遍历
        KthNode(pRoot.left, k);
        numsArr.add(pRoot);
        KthNode(pRoot.right, k);
        //等中序遍历结束后
        if(numsArr.size() < k)
            return null;
        
        return numsArr.get(k-1);        
    }


}


/*
//暴力法,缺点是需要一次这一课树后，再一次遍历数组
//在不知道BST中序遍历就是排序数组的时候，层序遍历节点值后存储到一个数组，升序排序
//找出排序后的第k个节点;然后再遍历这一棵树形成的数组，当发现节点值相等的时候返回这个节点
public class Solution {
    
    public TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0){
            return null;
        }
        ArrayList<Integer> valArr = new ArrayList<>();  //存储层序遍历的树节点的值
        ArrayList<TreeNode> nodeArr = new ArrayList<>(); //存储层序遍历的树节点
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();//用LinkedList模拟层序遍历使用的队列
        
        nodeQueue.add(pRoot); //初始化队列
        //开始层序遍历
        while(nodeQueue.size() != 0){
            TreeNode temp = nodeQueue.pollFirst();
            nodeArr.add(temp);
            valArr.add(temp.val);
            if(temp.left != null) nodeQueue.add(temp.left);
            if(temp.right != null) nodeQueue.add(temp.right);
        }
        if(valArr.size() < k)
            return null;
        //升序排序值数组，找出第k小，索引值是k-1
        Collections.sort(valArr);
        int keyVal = valArr.get(k-1);
        //找出树节点数组是这个值的节点，找到就返回
        for(TreeNode tempNode : nodeArr){
            if(tempNode.val == keyVal){
                return tempNode;
            }
        }
        return null;
        
        
        
    }
    
    
}

*/

