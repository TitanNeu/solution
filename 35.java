/**
 * 题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5

示例1

输入
1,2,3,4,5,6,7,0

输出
7
 * 
 */

public class Solution {
    
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1)
            return 0;
        int[] result = new int[array.length];
        return mergeSort(array, result, 0, array.length-1);
    }
    //实际上是归并排序
    public int mergeSort(int[] arr, int[] result, int head, int tail){
        if(arr == null || head >= tail || arr.length <= 1){
            return 0;
        }
        int mid = (head+tail)/2;
        int start1 = head, end1 = mid;
        int start2 = mid+1, end2 = tail;
        
        int p = 0;//合并序列时逆序对的个数
        //1序列逆序对个数
        int p1 = mergeSort(arr, result, start1, end1);
        //2序列逆序对个数
        int p2 = mergeSort(arr, result, start2, end2);
        
        int k = start1;
        //从小到大排列
        while((start1 <= end1) && (start2 <= end2)){
            if(arr[start1] <= arr[start2]){
                result[k++] = arr[start1++];
            } else {
                /*
                    由于两个递归是升序排列的，所以arr[start1]>arr[start2]时候,
                    1序列start1之后的元素都大于arr[start2]
                */
                //core，这是逆序对的个数，注意这里是累加p
                p += end1-start1+1; 
                //数值过大求余,一定加在这里每一轮都要判断p
                if(p>=1000000007)
                {
                    p%=1000000007;
                }
                result[k++] = arr[start2++];
            }
        }
        
        while(start1 <= end1){
            result[k++] = arr[start1++];
        }
        while(start2 <= end2){
            result[k++] = arr[start2++];
        }
        
        //注意这里不能少了拷贝，不然数组永远是原始数组，会影响归并结果
        for(k = head; k <= tail; k++){
            arr[k] = result[k];
        }
        
        //不要忘了求余判断
        return (p1+p2+p)%1000000007;
    }
}