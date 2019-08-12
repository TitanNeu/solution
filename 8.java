/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

 //非递归法
class Solution2 {
    public int JumpFloor(int target) {
        if(target <= 0)
            return 0;
        int pre1 = 1; 
        int pre2 = 2;
        if(target == 1 || target == 2){
            return target;
        }
        for(int i = 1; i < target; i++){
            int temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre1;
    }
}
//递归法
class Solution {
    public int JumpFloor(int target) {
        if(target <= 0)
            return 0;
        
        if(target == 1 || target == 2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}