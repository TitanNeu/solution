/**
 * 
 * 题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * 
 * 
 * 
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

//from top to bottom
class Solution2 {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        
        root.left = rightNode;
        root.right = leftNode;
        Mirror(root.left);
        Mirror(root.right);
                

        
    }
}

//Building mirror tree from its bottom to top.

public class Solution{
    public void Mirror(TreeNode root){
        if(root == null)
            return;
        buildMirror(root);
    }
    
    public TreeNode buildMirror(TreeNode root){
        if(root == null)
            return null;
        TreeNode leftRoot = buildMirror(root.left);
        TreeNode rightRoot = buildMirror(root.right);
        
        root.left = rightRoot;
        root.right = leftRoot;
        
        
        return root;
    }
}
