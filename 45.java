/**
 * 题目描述
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */

import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int len = numbers.length;
        int cntZero = 0;
        int i = 0;
        for(i = 0; i < len; ++i){
            if(numbers[i] == 0)
                ++cntZero;
        }
        //因为有cntZero个0,所以排序后0的部分不用判断，直接从不为0(大小王)的扑克开始
        for(i = 0; i < len - 1; ++i){
            //大小王不用判断
            if(numbers[i] == 0)
                continue;
            if(numbers[i] == numbers[i+1]){ //有对子
                break;
            }
            if(numbers[i+1]-numbers[i] == 1){ //前后是连续扑克
                continue;
            }
            //前后扑克不连续，找出不连续的牌前后差几张牌，并且判断当前大小王是不是够填充缺失的
            if(numbers[i+1]-numbers[i]-1 <= cntZero){ //两张牌缺失的牌数量不大于当前拥有的大小王数量
                cntZero -= numbers[i+1]-numbers[i]-1;
            } else{ //不够就跳出
                break;
            }
            
        }
        //如果上面的循环执行到最后一轮，说明牌可以组成顺子, 否则不是
        return (i==len-1)? true: false;
    }
}