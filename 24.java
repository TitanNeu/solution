/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
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
//标记
//深度优先
//建立一个自定义的比较规则，按照内部元素的长度从大到小排列
class compareArrLen implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
        return a2.size() - a1.size();
    }
}

public class Solution {
    //存储符合条件的路径
    private ArrayList<Integer> path = new ArrayList<>();
    //存储所有符合条件的路径
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return paths;
        }
        //
        path.add(root.val);
        target -= root.val;
        //如果当前的路径的所有节点的和是target，并且这个节点叶子节点，加入这一条路径
        if(target == 0 && root.left == null && root.right == null){
            paths.add(new ArrayList<Integer>(path));
            Collections.sort(paths, new compareArrLen());
        }
        //继续在左子树中寻找路径
        FindPath(root.left, target);
        //继续在右子树中寻找路径
        FindPath(root.right, target);
        //back to the nearest root node
        path.remove(path.size()-1);
        
        return paths;
    }
}
