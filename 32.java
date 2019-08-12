/**
 * 题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
则打印出这三个数字能排成的最小数字为321323。
 */


import java.util.*;
//解法1:利用全排列
class Solution2 {
    ArrayList<String> res = new ArrayList<>();
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length <= 0){
            return "";
        }
        permutationNumbers(numbers, 0, res);
        //进行字符串的字典序排序
        Collections.sort(res);
        return res.get(0);
        

    }
    public void swap(int[] numbers, int index1, int index2){
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
    
    //返回包含所有全排列数字的一个集合
    public void permutationNumbers(int[] numbers, int fixedIndex, ArrayList<String> result){
       
        if(fixedIndex == numbers.length-1){ //如果fixedIndex发现到了尾部，则可用元素只有这一个，只有一个全排列，遍历一下输出
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < numbers.length;i++){
                sb.append(numbers[i]);
            }
            
            //如果不允许元素重复，需要添加  if(!result.contains(String.valueOf(sb)))这个判断
            result.add(String.valueOf(sb));
        } else {
            //从fixedIndex开始,包括fixedIndex数字还没有被使用过，可以从中选一个放到fixedIndex位置
            for(int j = fixedIndex; j < numbers.length; j++){
                swap(numbers, fixedIndex, j);
                //选定fixedIndex位置元素后，再求后面数字的全排列
                permutationNumbers(numbers, fixedIndex+1, result); 
                //将fixedIndex位置的元素再还原，还原原始数组
                swap(numbers, fixedIndex, j);
                
            }
        }
    }
}



//解法2: 利用Comparator,重写内部的compareTo(T o1, T o2);

public class Solution {
    public String PrintMinNumber(int [] numbers){
        if(numbers == null || numbers.length == 0)
            return "";
        //存储numbers里面数字的字符串形式 
        ArrayList<String> strArr = new ArrayList<>();
        //拼接按顺序排列好的字符串
        StringBuilder sb = new StringBuilder();
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            strArr.add(String.valueOf(numbers[i]));
        }
        //strArr中的元素，两两之间用自定义的compare规则去比较
        Collections.sort(strArr, new CombineCompare());
        //将按规则排好的字符串数组拼接成字符串
        for(String str: strArr){
            sb.append(str);            
        }   
        return String.valueOf(sb);
    }


}
// 继承并重写Comparator接口里面的compare(String o1, String o2)
//    可以自定义两个对象的比较规则

class CombineCompare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        //输入为两数字符串，对字符串进行两种方式拼接
        String s1 = o1+o2;
        String s2 = o2+o1;
        //当符串字典序 o1+o2 < o2+o1时，return -1; 用CombineCompare排序后，o1在前,o2在后;其余三种情况同理
        return s1.compareTo(s2);
    }
    
}









