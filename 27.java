/**
 * 题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0)
            return res;
        char[] chArr = str.toCharArray();
        //HashSet<String> hashSet = new HashSet<>();
        permutation(chArr, res, 0);
        /*
        for(String strTemp : hashSet){
            res.add(strTemp);
        }
        */
        Collections.sort(res);
        return res;
            
            
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    public void permutation(char[] chArr, ArrayList<String> res, int fixedIndex){
        if(chArr == null || chArr.length == 0 || fixedIndex > chArr.length-1)
            return;
        int len = chArr.length;
        //如果已经选定到了字符的最后一个元素，一个全排列形成，可以作为一组结果添加
        if(fixedIndex == len-1){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++){
                sb.append(chArr[i]);
            }
            /*
            //hashSet可以防止添加重复元素，HashSet不是线程安全的
            hashSet.add(String.valueOf(sb));
            */
            //保证无重复
            if(!res.contains(String.valueOf(sb))){
                res.add((String.valueOf(sb)));
            }
        } else{
            //字符的排列还没有完全的选定,如果固定的位置超出了字符的最大的索引，则进不了这个循环
            for(int i = fixedIndex; i < len; i++){
                //依次将待选定位置fixedIndex的元素，从自己开始，与之后的元素进行交换，模拟全排列操作
                swap(chArr, fixedIndex, i);
                //fixedIndex位置的元素上一步暂时选定，进行后面字符的全排列
                permutation(chArr, res, fixedIndex+1);
                //全排列结束后，恢复到交换之前的状态。
                swap(chArr, fixedIndex, i);
            }
        }
    
    }
}