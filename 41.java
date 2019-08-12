/**
 * 题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */


import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum <= 0)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //建立一个滑动窗口，滑动窗口尺寸大于1，窗口内部是连续的正树序列
        int head = 1;
        int tail = 2;
        while(head < tail){
            //窗口内部的数列求和
            int curSum = (head+tail)*(tail-head+1)/2;
            //窗口内部和小于sum，右边界右移动一位
            if(curSum < sum){
                ++tail;
                
            } else if(curSum > sum){ //窗口内部和大于sum，左边界右移动一位
                ++head;
            } else{ //找到了符合条件的窗口，将元素添加为一个数组
                ArrayList<Integer> numArr = new ArrayList<>();
                for(int i = head; i <= tail; i++){
                    numArr.add(i);
                }
                //结束后，一定要变更窗口的大小
                ++head;
                //res.add(new ArrayList<Integer>(numArr));
                //因为数组的作用域仅仅在else内部。所以不需要用上面的方式写
                res.add(numArr);

            }
        }
        
        return res;
    }
}