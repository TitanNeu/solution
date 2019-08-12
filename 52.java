/**
 * 题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

 /*
当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

当模式中的第二个字符是“*”时：
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；

*/
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;
        return isMatch(str, 0, pattern, 0);
    }
    
    public boolean isMatch(char[] str, int strIndex, char[] pattern, int patIndex){
        int strLen = str.length; //字符串的长度
        int patLen = pattern.length; //模式的长度
        if(strIndex == strLen && patIndex == patLen) //字符和模式都已经匹配完了最后一位
            return true;
        if(strIndex < strLen && patIndex == patLen){//模式字符用完了，字符还没有匹配结束
            return false;
        }
        
        if(patIndex+1 < patLen && pattern[patIndex+1] == '*'){ //当前使用的pattern字符的下一个字符是'*'
            if(strIndex < strLen && (pattern[patIndex] == str[strIndex] || pattern[patIndex] == '.')){ //第一个字符可以匹配上
                return isMatch(str, strIndex, pattern, patIndex+2)|| //匹配上了，但不用pattrn中x*这两个字府
                    isMatch(str, strIndex+1, pattern, patIndex+2)||  //匹配上了，x*这一对只与目标中匹配好的字符用一次
                    isMatch(str, strIndex+1, pattern, patIndex);  //匹配上了，x*会重复使用，目标字符后移一位
            } else{ //第一个字符不匹配
                return isMatch(str, strIndex, pattern, patIndex+2);
            }
        } else { //当pattern目前位置后面的字符不是'*'，或者pattern目前的位置，是pattern数组最后的一个字符的时候
              if(strIndex < strLen && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
                  return isMatch(str, strIndex+1, pattern, patIndex+1);
              }
        }
        //其余的情况模式字符pattern均不能转换为str
        return false;
        
        
    }
}