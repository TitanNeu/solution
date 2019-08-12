/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {
    public double Power(double base, int exponent) {
        /*
        return Math.pow(base, exponent);
        */
        //这里一定要判断
        if(exponent == 0)
            return 1.0;
        //判断指数是不是负数
        boolean isNegExp = exponent < 0? true:false;
        //求指数的绝对值
        int absExp = Math.abs(exponent);
        double mul = base;
        //初始化是base，n次方就是再乘n-1次
        for(int i = 1; i < absExp; i++){
            mul *= base;
        }
        
        return isNegExp? 1.0/mul:mul;
        
        
  }
}