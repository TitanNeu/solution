/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reBuildBTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    public TreeNode reBuildBTree(int[] pre, int preHead, int preTail, int[] in, int inHead, int inTail){
        if(preHead > preTail || inHead > inTail)
            return null;
        TreeNode root = new TreeNode(pre[preHead]);
        for(int i = inHead; i <= inTail; i++){
            if(in[i] == root.val){
                root.left = reBuildBTree(pre, preHead+1, i-inHead+preHead, in, inHead, i-1);
                root.right = reBuildBTree(pre, i-inHead+preHead+1, preTail, in, i+1, inTail);
            }
        }
        
        return root;
    }
}