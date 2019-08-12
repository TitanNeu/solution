/**
 * 题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

 //num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果


//使用了HashSet可以散列查找的特性

import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
            return;
        HashSet<Integer> hSet = new HashSet<>();
        int len = array.length;
        for(int i = 0; i < array.length; i++){
            if(!hSet.contains(array[i])){
                hSet.add(array[i]);
            } else {
                hSet.remove(array[i]);
            }
        }
        /*
        int[] tempArr = new int[2];
        int i = 0;
        for(int temp:hSet){
            tempArr[i++] = temp;
        }
        num1[0] = tempArr[0];
        num2[0] = tempArr[1];
        */
        //次数标识号
        int k = 0;
        for(int temp: hSet){
            if(k % 2 == 0){
                num1[0] = temp;
                k++;
            } else{
                num2[0] = temp;
                k++;
            }
        }
           
        
    }
}

//利用数字与自身异或为0
class Solution2 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        
        int xorVal = 0;
        int len = array.length;
        int flag = 1;
        for(int i = 0; i < len; ++i){  //最后xorVal的值肯定是两个待求数字异或的值
            xorVal ^= array[i];
        }
       
        while((flag & xorVal) == 0){ //找出xorVal从左起第一个为1的位置，此处异或为1，说明两个待求数字此位置数不同
            flag <<= 1;
        }
        //根据标记的位置，可以将数组分组
        for(int k = 0; k < len; ++k){
            //但这里有个问题是，先判断==0，改成判断==1之后，程序不通过
            if((flag & array[k]) == 0){
                num2[0] ^= array[k];
            } else {
                num1[0] ^= array[k];
            }
        }
        
    }
    
    
}
