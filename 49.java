/**
 * 题目描述
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。


输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0

示例1
输入
+2147483647
    1a33

输出
2147483647
    0
 */

public class Solution {
    public int StrToInt(String str) {
        //空串或者是空指针
        if(str == null || str.length() == 0)
            return 0;
        char[] chArr = str.toCharArray();
        int strLen = str.length();
        //负数的符号标志
        boolean isNeg = (chArr[0] == '-')? true:false;
        //如果前面有符号位，从第二位开始计算,索引是1
        int startIndex = (chArr[0] == '-' || chArr[0] == '+')? 1:0;
            
        double sum = 0.0;
        
        for( ; startIndex < strLen; startIndex++){
            if(chArr[startIndex] < '0' || chArr[startIndex] > '9'){
                return 0;
            }
            //指数的计算:
            //1.首先计算参与运算的数字有多少位： (strLen-1)-startIndex+1 = strLen-startIndex
            //2.因为循环字符串生成的数组，相当从数字的高位开始计算，一个长度是strLen-startIndex的数字，从左往右数，最高位的数字的索引是strLen-startIndex-1
            sum += (chArr[startIndex] - '0') * Math.pow(10, strLen-1-startIndex);
        }
        
        //判断有没有超过Integer的范围
        if((isNeg && -sum < Integer.MIN_VALUE) || (!isNeg && sum > Integer.MAX_VALUE))
            return 0;
        return isNeg?(int)-sum:(int)sum;
    }
}