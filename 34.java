/**
 * 题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        //char类型可以转换成数值形式
        char[] chArr = str.toCharArray();
        //建立能容纳所有英文字母ASCII出现频数的数组，'z'的ASC是最大的索引，所以数组的长度要比索引大1
        int[] cnt = new int[256];
         //chArr[]中的char可以自动转成int，字符的频数计数
        for(int temp:chArr){
            ++cnt[temp];
        }
        
        for(int i = 0; i < chArr.length; ++i){
            //遍历字符数组，根据其第i位置的ASC值作为索引，查找频数数组
            //当发现第一个频数为1的ASC时，返回这个ASC在strArr[]中的索引
            if(cnt[chArr[i]] == 1){
                return i;
            }       
        }
        return -1;
    }
}