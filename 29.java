/**
 * 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.*;
public class Solution {
    ArrayList<Integer> resultArray = new ArrayList<Integer>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //insertSort(input);
        //bubbleSort(input);
        //Arrays.sort(input);
        quickSort(input);
        //chooseSort(input);
        //mergeSort(input);
        //
        //heapSort(input);
        //希尔排序
        //shellSort(input);
        //attention! k必须比数组要小
        if(k > input.length)
            return resultArray;
        for(int i = 0; i < k; i++){
            resultArray.add(input[i]);
        }
        return resultArray;
        
    }
    //插入排序
    public void insertSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        //正在比对的位置
        int j = 0;
        int len = arr.length;
        //假设index为0的数字已经固定，从1开始
        for(int i = 1; i < len; i++){
            //暂存i位置牌的值
            int temp = arr[i];
            //逐个处理从i往前的牌
            for(j = i; j > 0 && arr[j-1] > temp; j--){
                //将j位置的牌用j-1位置的替代，相当于前向过滤
                arr[j] = arr[j-1];
            }
            //j-1位置不再大于temp或者j-1=0的时候，将temp放到j位置
            arr[j] = temp;
        }
    }
    
    //希尔排序，属于插入排序类
    public void shellSort(int[] input){
        if(input == null || input.length <= 1)
            return;
        
        int len = input.length;
        //间隔D设置为len/2, len/4, len/8 ... 1这种
        int D = len/2;
        int i = 0;
        int j = 0;
        //间隔每次减半，直到1
        for(D = len/2; D > 0; D /= 2){
            //插入排序
            for(i = D; i < len; i++){
                int temp = input[i];
                for(j = i; j >= D && input[j-D] > temp; j -= D){
                    input[j] = input[j-D];
                }
                input[j] = temp;
            }
        }
    }
    
    
    public void swap(int[] arr, int j, int i){
        if(arr == null || arr.length == 0)
            return;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    
   
    /**********************************************/
    public void bubbleSort(int[] arr){
        if(arr == null || arr.length == 1)
            return;
        int len = arr.length;
        //数组有序标志位
        boolean flag = true;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len-1-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    flag = false;
                }
               
            }
            //如果前面的小循环一次也没有进入，则说明数据有序，不需要排序
            if(flag == true)
                break;
        }
        
    }
    /*******************************************/    
    public void quickSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        quickSortCore(arr, 0, arr.length-1);
    }
    public int findMidVal(int[] arr, int head, int tail){
        
        int mid = (head+tail)/2;
        if(arr[head] > arr[mid]) swap(arr, head, mid);
        if(arr[head] > arr[tail]) swap(arr, head, tail);
        if(arr[mid] > arr[tail])  swap(arr, mid, tail);
        
        return arr[mid];
        
    }
    public void quickSortCore(int[] arr, int head, int tail){
        if(arr == null || arr.length == 1 || head >= tail)
            return;
        int i = head;
        int j = tail;
        int pivot = findMidVal(arr, head, tail);
        while(i <= j){
            //这里一定是小于号
            while(arr[i] < pivot){++i;}
            while(arr[j] > pivot){--j;}
            if(i == j){
                ++i;
            }else if(i < j){//这里必须要写明是i < j,而不能是else，这可能有i > j的情况
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        quickSortCore(arr, head, j);
        quickSortCore(arr, i, tail);
        
    }
/**************************************************/
    public void chooseSort(int[] array){
        if(array == null || array.length <= 1)
            return;
        int len = array.length;
        for(int i = 0; i < len; i++){
            int minVal = array[i];
            int minIndex = i;
            for(int j = i; j < len; j++){
                if(array[j] < minVal){
                    minVal = array[j];
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        
    }
/**************************************************/    
    public void mergeSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        int len = arr.length;
        int[] result = new int[len];
        mergeSortCore(arr, result, 0, len-1);
    }
    
    public void mergeSortCore(int[] arr, int[] result, int head, int tail){
        if(arr == null || arr.length <= 1 || head >= tail)
            return;
        int mid = (head+tail)/2;
        int start1 = head, end1 = mid;
        int start2 = mid+1, end2 = tail;
        
        mergeSortCore(arr, result, start1, end1);
        mergeSortCore(arr, result, start2, end2);
        
        int k = head;
        while(start1 <= end1 && start2 <= end2){
            if(arr[start1] < arr[start2]){
                result[k++] = arr[start1++];
            } else {
                result[k++] = arr[start2++];
            }            
        }
        
        while(start1 <= end1){
            result[k++] = arr[start1++];
        }
        while(start2 <= end2){
            result[k++] = arr[start2++];
        }
        
        for(k = head; k <= tail; k++){
            arr[k] = result[k];
        }
        
    }
    
    //堆排序,首先调整以p为根的堆成最大堆
    public void heapSortCore(int[] array, int p, int len){
        //要整理的数组的索引在[0, len-1]之间，如果数组的长度小于等于0，没必要进行排序
        //如果要调整的根节点的索引超出了数组的索引范围
        if(array == null || array.length <= 0 || len <= 0 || p >= len || p < 0)
            return;
        int root = array[p];
        int parent = p, child = 0;
        for(; parent*2+1 <= len-1; parent = child){
            child = parent*2+1;
            if(child!=len-1 && array[child] < array[child+1]){
                ++child;
            }
            if(root > array[child]){
                break;
            } else {
                array[parent] = array[child];
            }
        }
        array[parent] = root;
        
    }
    
    public void heapSort(int[] array){
        if(array == null || array.length <= 1)
            return;
        int len = array.length;
        for(int p = (len-1)/2; p >= 0; p--){
            heapSortCore(array, p, len);
        }
        for(int i = len-1; i >= 0; i--){
            //实际上是删除最大堆操作
            swap(array, 0, i);
            heapSortCore(array,0,i);
        }
        
    }
}
