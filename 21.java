/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || pushA.length == 0 || popA == null || popA.length == 0)
            return false;
        if(pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        //pushA将要push进元素的索引
        int pushIndex = 0;
        //popA已经比对到的元素的索引
        int popIndex = 0;
        //当popA和pushA的索引都不会超出数组的范围的时候
        while(pushIndex < pushA.length && popIndex < popA.length){
            //每次先push进stack
            stack.push(pushA[pushIndex++]);
            //在stack不空的前提下判断顶部元素，若它与目前弹出序列正在比对位置的元素相同，则一直弹出，同时popA的索引不断后移。
            while(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                popIndex++;
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}