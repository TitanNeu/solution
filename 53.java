/**
 * 题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */


//正则表达式解法
/*
public class Solution {
    public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
*/
public class Solution {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0)
            return false;
        //出现一次就变为true
        boolean hasE = false; //e出现标志
        boolean hasPoint = false; //.出现标志
        boolean hasSign = false; //+-出现标志
        int len = str.length;
        for(int i = 0; i < len; i++){ //判断各种不合法的情况
            
            if(str[i] == '-' || str[i] == '+'){
                if(i == 0){
                    hasSign = true;
                } else {//当符号位置不是第0位置的时候，必须要求前面的一个相邻的字符是‘e’ || 'E'
                    if(str[i-1] != 'E' && str[i-1] != 'e'){
                        return false;
                    } else {
                        hasSign = true;
                    }
                }
            } else if(str[i] == 'e' || str[i] == 'E'){//目前是指数标志
                //指数位出现两次不合法,指数位在第一位或者最后一位，不合法
                if(hasE || i == len-1 || i == 0) return false;
                
                hasE = true;
            } else if(str[i] == '.'){//目前是'.'
                //点在指数标志之后，或者第二次出现点，或点出现在末尾，不合法
                if(hasE || hasPoint || i == len-1) return false;
                hasPoint = true;
            } else if(str[i] < '0' || str[i] > '9'){ //读到数字，超出范围不合法
                
                return false;
            }

        }
        return true;
        
        
    }
}