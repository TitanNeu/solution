/**
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。

*/

import java.util.*;
public class Solution {
    //Insert one char from stringstream
    private ArrayList<Character> chArr = new ArrayList<>();
    public void Insert(char ch)
    {
        //将字符存储到变长数组
        chArr.add(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int len = chArr.size();
        if(len == 0)
            return '#';
        //建立一个以ASC作为索引的数组,char共有256种情况
        int[] cnt = new int[256];
        //按照字符ASC出现的次数进行统计
        for(char ch: chArr){
            ++cnt[ch];
        }
        //再次遍历字符数组，按顺序查看每一个字符出现频率。第一次找到频数1的时候字符就返回这个字符
        for(char ch: chArr){
            if(cnt[ch] == 1)
                return ch;
        }
        return '#';
    }
}