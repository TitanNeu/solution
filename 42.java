/**
 * 题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
import java.util.*;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if(array == null || array.length <= 1)
            return new ArrayList<Integer>();
        Arrays.sort(array);
        ArrayList<Integer> res = new ArrayList<>();
        //设立左右两个指针
        int left = 0;
        int right = array.length-1;
        while(left < right){
            if(array[left] + array[right] > sum){
                right--;
            }else if(array[left] + array[right] < sum){
                left++;
            } else {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }
            
        }
        return res;
    }
}

class Solution2 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if(array == null || array.length <= 1)
            return new ArrayList<Integer>();
       
        ArrayList<Integer> res = new ArrayList<Integer>();
        int minMul = 0;
        boolean isFirst = true;
        for(int i = 0; i < array.length; i++){
            int target = sum-array[i];
            //相同的跳过
            if(target == array[i])
                continue;
            //第一次找到一对符合条件的
            if(isFirst && findComp(array, target)){
                minMul = target * array[i];
                res.add(array[i]);
                res.add(target);
                isFirst = false;
            } 
            //找到符合条件的，但不是第一次
            if(findComp(array, target)){
                if(array[i]*target < minMul){
                    minMul = array[i]*target;
                    res.clear();
                    res.add(array[i]);
                    res.add(target);
                }
            }
            
        }
        Collections.sort(res);
        return res;
        
        
    }
    
    //二分查找一个数的互补数
    private boolean findComp(int[] array, int target){
        int head = 0;
        int tail = array.length-1;
        while(head <= tail){
            int mid = (head + tail)/2;
            if(array[mid] > target){
                tail = mid-1;
            } else if(array[mid] < target) {
                head = mid+1;
            } else{
                return true;
            }
        }
        return false;
        
    }
        
    
}
            
            
            
            