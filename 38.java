/**
 * 题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

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
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        //左子树高度
        int highL = TreeDepth(root.left);
        //右子树高度
        int highR = TreeDepth(root.right);
        //左右高度最大的，再加上根节点的1,就是树高
        return highL > highR? ++highL: ++highR;
        
        
    }
}