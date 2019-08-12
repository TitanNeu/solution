//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。


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

/*
二叉查找树（英语：Binary Search Tree），也称为二叉搜索树、有序二叉树（ordered binary tree）或排序二叉树（sorted binary tree），是指一棵空树或者具有下列性质的二叉树：

若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
任意节点的左、右子树也分别为二叉查找树；
没有键值相等的节点。
*/
public class Solution{
    /*
    树节点形成的有序的双向链表,定义树节点内部，
    左指向的是前驱节点，右指向的是后继节点
    */
    public TreeNode Convert(TreeNode root){
        if(root == null){
            return null;
        }
         //找到右子树形成的双向链表的开始节点
        TreeNode rightHead = Convert(root.right);
        if(rightHead != null){
            //根后继节点是右子树形成双向链表的头节点
            root.right = rightHead;
            //右子树形成双向链表的头节点前驱节点是根
            rightHead.left = root;
        }
        
        //左子树生成的双向链表的头
        TreeNode leftHead = Convert(root.left);
        //用于寻找坐子树构造的双向链表的尾部，初始化为左子树双向链表的头节点。
        TreeNode leftTail = leftHead;
        //找到左子树生成的双向链表的最后一个节点，
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
       
        if(leftHead != null){//leftHead不是null，则这个链表最后一个节点一定存在
            //左树构成的链表的尾部节点的后继节点指向root
            leftTail.right = root;
            //root节点的前驱节点是左树链表的最后一个节点
            root.left = leftTail;
            return leftHead;
        }
        return root;
    }
}
/*
public class Solution {
//1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
//2、定位到左链表的最后一个节点(左子树最右边的节点)
//3、如果左子树链表不为空，则将当前root追加到左子树链表后
//4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
//5、如果右子树链表不为空，将右子树链表追加到当前root后
//6，根据左子树链表是否为空返回的整体双向链表的头节点

//Convert函数把一个二叉搜索树变成一个有序的双向链表，返回双向链表的头结点，参数root为二叉搜索树的根节点
    public TreeNode Convert(TreeNode root){
        if(root==null){//假如根节点为空，返回空
            return null;
        }
        if(root.left==null&&root.right==null){//假如只有一个根节点，则返回根节点
            return root;
        }
    //1、将左子树构造成双链表，并返回该链表头结点left
        TreeNode left=Convert(root.left);

    //2、定位到左子树链表的最后一个节点（左子树最右边的节点）
        TreeNode p=left;//创建一个临时节点P,用来遍历找到左链表的最后一个节点(左子树最右边的节点)，p初始化指向做左子树的根节点，
        while(p!=null&&p.right!=null){
            p=p.right;//最终p为左子树最右边的节点
        }
    //3、如果左子树链表不为空，将当前root追加到左子树链表后
        if(left!=null){//左子树链表不为空
            p.right=root;//左子树链表的最后一个节点p（左子树最右边节点）的右指针指向当前root节点
            root.left=p;//当前root节点的左指针指向左子树链表的最后一个节点p（左子树最右边节点）
        }
    //4、将右子树构造成双链表，并返回该链表的头结点right
        TreeNode right=Convert(root.right);

    //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if(right!=null){//右子树链表不为空
            right.left=root;//右子树链表的头结点right的左指针指向当前root
            root.right=right;//当前root的右指针指向右子树链表的头结点right
        }
        return left!=null?left:root;//根据左子树链表是否为空返回整个双向链表的头指针。  
    }
}
*/

