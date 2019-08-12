
/**
 * 题目描述
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 *  */ 

public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0)
            return false;
        
        int rows = array.length;
        int column = array[0].length;
        boolean res = false;
        for(int row = 0; row < rows; row++){
            if(findTarget(array, row, 0, column-1, target))
                return true;
        }
        return res;
    }
    
    public boolean findTarget(int[][] array, int row, int head, int tail, int target){
        if(head > tail)
            return false;
        while(head <= tail){
            int mid = (head+tail)/2;
            if(array[row][mid] > target){
                tail = mid-1;
            }else if(array[row][mid] < target){
                head = mid+1;
            }else{
                return true;
            }
        }
        return false;
        
    }
}