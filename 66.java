/**
 * 题目描述
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。

 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        return countFunc(threshold, 0, 0, rows, cols, flag);
         
    }
    public int countFunc(int threshold, int i, int j, int rows, int cols, boolean[][] flag){
        if(i < 0 || i > rows-1 || j < 0 || j > cols-1)
            return 0;
        boolean illeegal = (calNumSum(i)+calNumSum(j)) > threshold; //数字的和有没有越界
        if(flag[i][j] == true || illegal){
            return 0;
        }
        flag[i][j] = true; //当前(i, j)符合条件
        return countFunc(threshold, i, j-1, rows, cols, flag)+
               countFunc(threshold, i, j+1, rows, cols, flag)+
               countFunc(threshold, i-1, j, rows, cols, flag)+
               countFunc(threshold, i+1, j, rows, cols, flag)+
               1;
        
    }
    
    public int calNumSum(int i){ //求一个整数的每一个数字相加的和
        int numSum = 0;
        while(i != 0){
            numSum += i%10;
            i /= 10;
        }
        return numSum;
    }
}
