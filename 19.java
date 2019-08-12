/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

 //标记
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        //对于偶数n有n/2对，对于奇数有n/2+1对
        int n = Math.min(row, column);
        int round = (n%2 == 0)?n/2:(n+1)/2;

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < round; i++){
            //left to right 列计数
            for(int l2r = i; l2r < column-i; l2r++){
                arr.add(matrix[i][l2r]);
            }
            //up to down 行计数
            for(int u2d = i+1; u2d < row-i; u2d++){
                arr.add(matrix[u2d][column-1-i]);
            }
            //right to left列计数
            for(int r2l = column-1-1-i; (r2l >= i)&&(row-1-i != i); r2l--){ //注意判别不是先前遍历过的一行
                arr.add(matrix[row-1-i][r2l]);
            }
            //down tp up 行计数作为循环条件
            for(int d2u = row-1-1-i; (d2u >= i+1) && (column-1-i != i); d2u--){//注意判别不是先前遍历过的一列
                arr.add(matrix[d2u][i]);
            }
        }
        return arr;
    }
}