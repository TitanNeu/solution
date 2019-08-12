/**
 * 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
import java.util.*;

//如果存在符合条件的数字。这个数字一定是排序之后数组，中间位置的数字。
//因为这个数字出现的次数大于数组的长度的一半
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        Arrays.sort(array);
        int len = array.length;
        int midVal = array[(len-1)/2];
        int midValCnt = 0;
        for(int i = 0; i < len; i++){
            if(array[i] == midVal){
                ++midValCnt;
            }
            
        }
        //不超过数组长度一半
        if(midValCnt > len/2)
            return midVal;
        return 0;
    }
}