/**
 * 题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

 //AVL树是空树,或者是左右两棵子树高度差不超过1的树，并且要求左右两棵子树也是AVL树

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        int HL = getHeigh(root.left);
        int HR = getHeigh(root.right);
        if(Math.abs(HL-HR) > 1) //子树高度超过1不是AVL树
            return false;
        //判断左右子树是不是AVL树
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        
    }
    //求树的高度
    public int getHeigh(TreeNode root){
        if(root == null)
            return 0;
        int HL = getHeigh(root.left);
        int HR = getHeigh(root.right);
        
        return HL>HR? HL+1:HR+1;
    }
}