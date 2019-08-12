/**
 * 题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] a) throws Exception {
        //A少于两个元素无法找到符合条件的b
        if(a == null || a.length < 2)
            throw new Exception();
        int aLen = a.length;
        int[] b = new int[aLen];
        //b[0]是特殊情况，从a[]索引是1的元素开始，B中除b[0]外，其余的都是从索引是0的A元素开始
        b[0] = a[1];
        for(int i = 2; i < aLen; i++){
            b[0] *= a[i];
        }
        //最外层i是B元素的索引，从b[1]开始
        for(int i = 1; i < aLen; i++){
            //每一轮开始给b元素乘积的初始值
            b[i] = a[0];
            //b[i]乘以索引在i之前的所有A元素
            for(int j = 1; j < i; j++){
                b[i] *= a[j];
                
            }
            //b[i]乘以所有索引在i之后的A元素
            for(int k = i+1; k < aLen; k++){
                b[i] *= a[k];
            }
        }
        return b;
        
    }
}