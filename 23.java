/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 */

/*二叉搜索树：
    一颗空树或者
    一颗不为空的树：
1. 非空左子树的所有键值都小于根节点的键值，
2. 非空右子树的所有键值都大于根节点的键值。
3. 左右两棵子树都是二叉搜索树
*/
//标记
class Solution2 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return recursionBST(sequence, 0, sequence.length-1);
        
    }
    
    public boolean recursionBST(int[] sequence, int startIndex, int endIndex){//序列，区间开始索引，结束索引
        //当区间不存在或者已经是1的时候, 一定是一个树的后序遍历序列
        if(startIndex >= endIndex){ 
            return true;
        }
        //这个index用于寻找右端点的开始索引，注意右子树可能会不存在
        int index = startIndex;
        //endIndex是当前区间段所能发现的某一个子树的根节点, 这个节点前面含有它的左右子树的遍历结果，由于是BST，所有根节点的左子树节点值都会小于它，所有右子树节点的值会大于它
        //下面的方法用于找到它的右子树开始的节点
        while(index < endIndex && sequence[index] < sequence[endIndex]){
            index++;
        }
        //右子树开始序列的的第一个节点，这个点，结合最后的根节点，将树分为了前半部分的左树和后半部分的右树
        int right = index;
        while(right < endIndex && sequence[right] > sequence[endIndex]){
            right++;
        }
        if(right != endIndex)
            return false;
        // 执行完上一个判断，到此处说明，根节点左子树的所有节点都小于根节点，根节点的右子树所有节点都大于根节点
        
        //递归遍历左子树和右子树       左子树                                    右子树
        return recursionBST(sequence, startIndex, index-1) && recursionBST(sequence, index, endIndex-1);
    }
}

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        
        return recursionBST(sequence, 0, sequence.length-1);
        
    }
    public boolean recursionBST(int[] arr, int head, int tail){
        if(head >= tail)
            return true;
        int root = arr[tail];
        //i是右子树的开始节点
        int i = head;
        for(; i < tail; i++){
            if(arr[i] > root){
               break;
            }
        }
        //k用于判断右子树的合法性，
        int k = i;
        for(; k < tail; k++){
            if(arr[k] < root){
                return false;
            }
            
        }
       
        
        return recursionBST(arr, head, i-1)&&recursionBST(arr, i, tail-1);
    }
}





