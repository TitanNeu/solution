/**
 * 题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
求按从小到大的顺序的第N个丑数。
 * 
 */

/*
    每一个丑数都是它前面一个，比它小的某一个丑数乘以2或3或5所得
    
*/
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        //标记索引位置

        //在res数组的t2位置之前的所有数字，乘以2都不大于res数组的最后一个丑数；t2位置以及之后所有数字，乘以2都大于res数组的最后一个丑数，可以作为新添加的备选丑数
        int t2 = 0;
        //同理
        int t3 = 0;
        //同理
        int t5 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for(int i = 1; i < index; ++i){
            //选择大于res[i]的最小丑数添加
            res[i] = Math.min(res[t2]*2, Math.min(res[t3]*3, res[t5]*5));
            //当t2标记处乘2不大于最后一个丑数，要将标记右移,以准备下一轮获取下一个丑数
            if(res[t2]*2 <= res[i]) ++t2;
            //同理
            if(res[t3]*3 <= res[i]) ++t3;
            //同理
            if(res[t5]*5 <= res[i]) ++t5;
        }
        //返回数组里面的最后一个，也就是第Index个
        return res[index-1];
    }
}
