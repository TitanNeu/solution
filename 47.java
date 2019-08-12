    /**
     * 题目描述
    求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */

    public class Solution {
        public int Sum_Solution(int n) {
            int sum = 1;
            //逻辑短路性，当n<=1的时候被短路，当n>1的时候开始执行后面的递归程序
            boolean a = (n > 1 && (sum = n+Sum_Solution(n-1)) > 1);
            return sum;
            
        }
    }