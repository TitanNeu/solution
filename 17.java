//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //当Tree1和Tree2都不为null的时候，才进行比较。否则直接返回false
        if(root1 == null || root2 == null)
            return false;
        
        
        //找到了可能的公共树的根节点
        if(root1.val == root2.val){
            if(areAllNodesSame(root1, root2)){
                return true;
            }     
        } 
        //如果找不到，去看以Tree1中，以root1的左儿子为根的子树，是否包含Tree2,或者以root1的右儿子为根的子树中，是否包含root2
        return HasSubtree(root1.right, root2) || HasSubtree(root1.left, root2);
        
    }
    
    /**
	 * 判断root2是不是root1的子集
     
     
	 * 1.如果root1 == null,root2!=null，这时候root1已经没有了，但是root2还有，显然root2不包含在root1中 
	 * 2.root2 == null,这时是root2没有了，说明root2中的节点一个一个的匹配root1的节点（顺序也一致），说明root2包含在root1中
	 * 3.root1.val != root2.val ，显然返回false 
	 * 4.root1.val == root.val
	 * 这时要继续递归，同时比较root1和root2的左右子树。
*/
        //只有在两个节点的值相等的时候才会做这个判断
    public boolean areAllNodesSame(TreeNode root1, TreeNode root2){
       
        //root1和root2已经都已经比对完了最后一个节点，且节点值都相等。这种情况是root1和root2是两棵相同的树
        if(root1 == null && root2 == null){
            return true;
        }
        //root1已经比对到头，root2还未比对到头，root2不是root1的子树
        if(root1 == null && root2 != null){
            return false;
        }
        //root2比对结束，root1还没有结束，root2是root1的子树
        if(root1 != null && root2 == null){
            return true;
        }
         //两个节点的值不相等，说明root2不是root1的子树
        if(root1.val != root2.val)
            return false;
        
        return areAllNodesSame(root1.left, root2.left) && areAllNodesSame(root1.right, root2.right);
    }
}