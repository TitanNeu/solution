/**
 * 题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */

 //标记
class Solution2 {
    public int FindGreatestSumOfSubArray(int[] array) {
        
        //假设初始时最大的是第一个元素；不能假设开始最大是0
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            int sum = 0;
            for(int j = i; j < array.length; j++){
                sum += array[j];
                if(max < sum){
                    max = sum;
                }
            }
        }
        return max;
    }
}


/*
    还有一种更好的解法，只需要O（N）的时间。因为最大 连续子序列和只可能是以位置0～n-1中某个位置结尾。当遍历到第i个元素时，判断在它前面的连续子序列和是否大于0，
    如果大于0，则以位置i结尾的最大连续子序列和,为元素i和前面的连续子序列和相加；否则，则以位置i结尾的最大连续子序列和为元素i。
*/
public class Solution{
    public  int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0]; //真正的子数组最大值
        int curMax = array[0];   //当前找到的连续序列可能的最大值
        for (int i = 1; i < array.length; i++) {
            //如果array[i]前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和暂时定为array[i]，
            //但是不一定是，比如前面和是-10，而array[i]是-20，所以还要进行后面的比较
            if(curMax <= 0){
                curMax = array[i];
            } else {//如果array[i]前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
                curMax += array[i];
            }
            //当前最大子序列和与之前的最大和比较，更新最大子序列的和
            max =  curMax > max? curMax : max;
        }
        return max;
    }
    
}