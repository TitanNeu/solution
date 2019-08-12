//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。


import java.util.Stack;

public class Solution {

    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int node) {
        if(s.isEmpty() && min.isEmpty()){
            s.push(node);
            min.push(node);
        }
        s.push(node);
        if(min.peek() > node){
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        if(s.isEmpty())
            return;
        s.pop();
        min.pop();
    }
    
    public int top() {
        if(s.isEmpty()) {
            try{
                throw new Exception();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
       return s.peek();
            
            
    }
    
    public int min() {
        if(s.isEmpty()) {
            try{
                throw new Exception();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return min.peek();
    }
}