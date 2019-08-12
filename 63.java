/**
 * 题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

import java.util.*;
public class Solution {
    private ArrayList<Integer> res;
    public void Insert(Integer num) {
        if(res == null)
            res = new ArrayList<>();
        res.add(num);
    }

    public Double GetMedian() {
        if(res == null){
            return 0.00001;
        }
        if(res.size() <= 1)
            //Integer自动拆箱为int后再转换成double
            return (double)res.get(0);
        Collections.sort(res);
        int len = res.size();
        int midIndex = len/2;
        
        int mid = res.get(midIndex);
        //如果
        int preMid = res.get(midIndex-1);
        boolean isOdd = (len%2==1)?true:false;
        return isOdd?mid:(mid+preMid)/2.0;
        
    }


}