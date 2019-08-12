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
        if(pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;
        return reBuildTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    //建立本轮的根节点    
    public TreeNode reBuildTree(int [] pre, int preHead, int preTail, int [] in, int inHead, int inTail){
        if(preHead > preTail || inHead > inTail){
            return null;
        }
        int rootVal = pre[preHead];
        TreeNode root = new TreeNode(rootVal);
        //寻找in[]数组的根节点的索引，分为左右子树
        int rootIndex = inHead;
        for(int i = inHead; i <= inTail; i++){
            if(in[i] == rootVal){
                rootIndex = i;
            }
        }
        // 在LVR遍历的数组中找到根节点的索引，将LVR序列分为左右子树，递归进行重建
        root.left = reBuildTree(pre, preHead+1, rootIndex-inHead+preHead, in, inHead, rootIndex-1);
        root.right = reBuildTree(pre, rootIndex-inHead+preHead+1, preTail, in, rootIndex+1, inTail);
        return root;
        
    }
}