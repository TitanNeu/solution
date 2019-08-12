/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
        n<=39
 */

class Solution {
    public int Fibonacci(int n) throws Exception{
        if(n < 0)
            throw new Exception();
        if(n == 0 || n == 1)
            return n;
        int pre1 = 0;
        int pre2 = 1;
        for(int i = 0; i < n; i++){
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre1;
    }
}

class Solution2 {
    public int Fibonacci(int n) throws Exception{
        if(n < 0)
            throw new Exception();
        if(n == 0 || n == 1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}