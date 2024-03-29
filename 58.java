/**
 * 题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

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
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)
            return true;
        //如果根节点不是null，开始判断他的左右子树
        return coreFunc(pRoot.left, pRoot.right);
    }
    //判断两个子树是不是对称
    boolean coreFunc(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left != null && right == null)
            return false;
        if(left == null && right != null)
            return false;
        if(left.val != right.val)
            return false;
        //全都符合过关
        //对称的时候：
        //1.左子树的左子树节点每一个都等于右子树的右子树节点；
        //2.左子树的右子树节点，每一个都等于右子树的左子树节点
        return coreFunc(left.left, right.right) && coreFunc(left.right, right.left);
    }

}


