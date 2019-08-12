//从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import java.util.*;
/**
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //用链表模拟队列
        LinkedList<TreeNode> qNode = new LinkedList<>();
        qNode.add(root);
        while(!qNode.isEmpty()){
            TreeNode tempNode = qNode.pollFirst();
            res.add(tempNode.val);
            if(tempNode.left != null) qNode.add(tempNode.left);
            if(tempNode.right != null) qNode.add(tempNode.right);
        }
        return res;
    }
}