/**
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/

//常规做法
class Solution2 {
    public String replaceSpace(StringBuffer str) {
    	if(str == null || str.length() == 0)
            return "";
        char[] chArr = String.valueOf(str).toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = chArr.length;
        for(int i = 0; i < len; i++){
            if(chArr[i] == ' '){
                sb.append("%20");
            } else{
                sb.append(chArr[i]);
            }
        }
        
        return String.valueOf(sb);
    }
}
//使用API
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0)
            return "";
        return String.valueOf(str).replaceAll(" ","%20");
        
    }
}