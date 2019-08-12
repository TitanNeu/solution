/**
 * 题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */

 //利用substring()进行拼接
class Solution2 {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0)
            return "";
        int strLen = str.length();
        //因为是循环移动，n如果超过strLen,等价于取余数后移动的位数
        n = n % strLen;  
        //substring() API全是小写
        
        //建立要移动的n位之后的字符组成的字符串
        StringBuilder sb = new StringBuilder(str.substring(n, strLen));
        //把要移动的前面n个字符，拼接到前面建立的字符串的后面，实现左循环移动n位的效果
        sb.append(str.substring(0, n));
        
        return String.valueOf(sb);
    }
}
//进行坐标的映射计算
public class Solution{
    public String LeftRotateString(String str,int n){
        if(str == null || str.length() == 0 || n < 0)
            return "";
        int strLen = str.length();
        //存储结果的数组
        char[] resArr = new char[strLen];
        char[] chArr = str.toCharArray();
        n = n % strLen;
        for(int i = 0; i < strLen; i++){
            //根据移动后的坐标，将当前的字符放到结果数组的指定位置
            if(i-n < 0){ 
                resArr[i-n+strLen] = chArr[i];
            } else {
                resArr[i-n] = chArr[i];
            }
        }
        return String.valueOf(resArr);
        
    }
}
