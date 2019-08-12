/**
 * 题目描述
统计一个数字在排序数组中出现的次数。
 */

 /*
//暴力法，时间复杂度n
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == k)
                ++count;
        }
        return count;
        
    }
}
*/
public class Solution{
    public int GetNumberOfK(int[] array, int k){
        if(array == null || array.length == 0)
            return 0;
        int len = array.length;
        boolean isUp = array[0] <= array[len-1];            
        
        int firstIndex = isUp?firstKPosUp(array, k, 0, len-1):firstKPosDown(array, k, 0, len-1);
        int lastIndex = isUp?lastKPosUp(array, k, 0, len-1):lastKPosDown(array, k, 0, len-1);
        
        if(firstIndex != -1 && lastIndex != -1)
            return lastIndex-firstIndex+1;
        
        return 0;
        
    }
    
    //find the first k's index, use bsearch, 只是用于升序
    public int firstKPosUp(int[] array, int k, int start, int end){
        if(array == null || start > end)
            return -1;
        int head = start;
        int tail = end;
        while(head <= tail){
            int mid = (head+tail)/2;
            if(array[mid] > k){
                tail = mid - 1;
            } else if(array[mid] < k){
                head = mid + 1;
            } else if(mid-1 >= head && array[mid-1] == k){
                tail = mid-1;
            } else {
                return mid;
            }
            
        }
        return -1;
    }
    //find the last k's index, use bsearch，只是用于升序
    public int lastKPosUp(int[] array, int k, int start, int end){
        if(array == null || start > end)
            return -1;
        int head = start;
        int tail = end;
        while(head <= tail){
            int mid = (head+tail)/2;
            if(array[mid] > k){
                tail = mid - 1;
            } else if(array[mid] < k){
                head = mid + 1;
            } else if(mid+1 <= tail && array[mid+1] == k){
                head = mid+1;
            } else {
                return mid;
            }
            
        }
        return -1;
    }
    
     //find the first k's index, use bsearch, 只是用于降序
    public int firstKPosDown(int[] array, int k, int start, int end){
        if(array == null || array.length == 0 || start > end)
            return -1;
        int head = start;
        int tail = end;
        while(head <= tail){
            int mid = (head+tail)/2;
            if(array[mid] > k){
                head = mid - 1;
            } else if(array[mid] < k){
                tail = mid + 1;
            } else if(mid-1 >= head && array[mid-1] == k){
                tail = mid-1;
            } else {
                return mid;
            }
            
        }
        return -1;    
    }
    
        //find the last k's index, use bsearch，只是用于降序
    public int lastKPosDown(int[] array, int k, int start, int end){
        if(array == null || start > end)
            return -1;
        int head = start;
        int tail = end;
        while(head <= tail){
            int mid = (head+tail)/2;
            if(array[mid] > k){
                head = mid + 1;
            } else if(array[mid] < k){
                tail = mid - 1;
            } else if(mid+1 <= tail && array[mid+1] == k){
                head = mid+1;
            } else {
                return mid;
            }
            
        }
        return -1;
    }
    
}



