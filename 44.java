/**
 * 题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 */

public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0)
            return "";
        String[] strArr = str.split(" ");
        if(strArr.length == 0) //如果str全是空格组成,原样输出str
            return str;
        StringBuilder sb = new StringBuilder();
        int strLen = strArr.length;
        //将strArr中的数据倒序添加，并在每一个添加的字段后面加空格，除了strArr[0]不添加
        for(int i = strLen-1; i >= 1; i--){
            sb.append(strArr[i]);
            sb.append(" ");
        }
        //strArr[0]是正序字符串sb的最后一个字段，后面没有空格，要单独处理
        sb.append(strArr[0]);
        return String.valueOf(sb);      
        
    }
}