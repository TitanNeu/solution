/**
 * 题目描述
请实现两个函数，分别用来序列化和反序列化二叉树
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
import java.util.*;
public class Solution {
    String Serialize(TreeNode root) {
        if(root == null)
            return "#,";
        StringBuilder sb = new StringBuilder();
        //前序遍历序列化树
        sb.append(root.val);
        sb.append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return String.valueOf(sb);
  }
    //所有节点String数组的索引
    private int index = 0; 
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0)
            return null;
        String[] strArr = str.split(",");
        int len = strArr.length;
        TreeNode root = null;
        //前序遍历反序列化树
        if(index < len){//节点数组没有使用完的情况下
            if(!strArr[index].equals("#")){
                root = new TreeNode(Integer.valueOf(strArr[index++]));
                root.left = Deserialize(str);
                root.right = Deserialize(str);               
            }else{
                index++;
            }
        }
        
        return root;
        
  }
}