/**
 * 
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
import java.util.*;
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)
            return;
        ArrayList<Integer> oddArr = new ArrayList<>();
        ArrayList<Integer> evenArr = new ArrayList<>();
        Arrays.sort(array);
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] %2 == 0){
                evenArr.add(array[i]);
            } else{
                oddArr.add(array[i]);
            }
        }
        for(int temp:evenArr){
            oddArr.add(temp);
        }
        
        int k = 0;
        for(int temp:oddArr){
            array[k++] = temp;
        }
        
            
    }
}