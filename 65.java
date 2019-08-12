/**
 * 题目描述
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        
        
        if(matrix.length < str.length || matrix == null || str == null){
            return false;
        }
        //创建一个标志矩阵，用来表示哪一个格子走过，默认是false，没有走过
        boolean[] judgeArr = new boolean[matrix.length];  
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(judgeFunc(matrix, i, j, rows, cols, 0, str, judgeArr)){
                    return true;
                }
            }
        }
        return false;
    }
    //用于寻找路径
    //其中i,j要开始递归查找路径的格子坐标，rows是行数，cols是列数,k是要匹配的字符数组的起始字符索引
    public boolean judgeFunc(char[] matrix, int i, int j, int rows, int cols, int k, char[] str, boolean[] judgeArr){ 
        
        if(k >= str.length) //已经匹配好了字符数组的最后一个字符,路径已经找到
            return true;
        
        if(i < 0 || j < 0 || i > rows-1 || j > cols-1)  //在还没有匹配成功时候矩阵越界; 与前面k的判断条件不能调换，因为数组越界的时候，可能恰好前一次找到了路径
            return false;        
        int index = i*cols+j; //计算在等价一维数组对应的坐标        
        if(matrix[index] != str[k] || judgeArr[index] == true)
            return false;
        
         /*
        
        //这边具有逻辑短路性质，如果前面的条件有一个满足了，后面的就不再执行。但是这句话有可能会发生越界matrix[index]越界，因为没有提前判断i和j的情况,
        if((matrix[index] != str[k] || flagArr[index] == true || i < 0 || i > rows-1 || j < 0 || j > cols-1))
            return false;
        */
        /*//这样写就不会发生数组越界的情景，但是这里可读性太差。把i和j修改为放到前面判断
        if(i < 0 || i > rows-1 || j < 0 || j > cols-1 || matrix[index] != str[k] || flagArr[index] == true)  
            return false; 
        */
        
        //到此为止index位置的字符匹配上了，不能再进入了
        judgeArr[index] = true;
        
        if(judgeFunc(matrix, i-1, j, rows, cols, k+1, str, judgeArr) ||
           judgeFunc(matrix, i+1, j, rows, cols, k+1, str, judgeArr) ||
           judgeFunc(matrix, i, j+1, rows, cols, k+1, str, judgeArr) ||
           judgeFunc(matrix, i, j-1, rows, cols, k+1, str, judgeArr)) 
        {
            return true;
        }
        //从匹配成功的index位置出发找不到一条可行的路径。将这个位置再次标记为没有走过
        judgeArr[index] = false;
        return false;
        
    }


}