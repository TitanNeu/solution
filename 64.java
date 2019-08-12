/**
 * 题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

 */

import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || num.length < size || num.length <= 0 || size <= 0)
            return new ArrayList<Integer>();
        //存储每个数组里面的最大值
        ArrayList<Integer> arrList = new ArrayList<>();
        int numLen = num.length;
        //i是滑动窗口的第一个元素索引，设大数组最后一个窗口的第一个元素索引是x，最后一个索引是len-1 则(len-1-x)+1 = size
        for(int i = 0; i <= numLen - size; i++){
           
            arrList.add(findMax(num, i, size+i-1));
        }
        return arrList;
        
    }
    //找出滑动窗口中元素的最大值
    public int findMax(int[] num, int head, int tail){
        
        int max = num[head];
        for(int i = head+1; i <= tail; i++){
            if(max < num[i])
                max = num[i];
        }
        
        return max;
        
    }
}