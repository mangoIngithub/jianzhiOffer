package jianzhioffer.chapter2;

import java.util.Stack;
/**题目：两个栈实现队列
 * 思路：入队：栈1直接压栈
 *      出队：栈2若为空，则把栈1的数据都弹出压到栈2， 最后弹出栈2
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
      stack1.push(node);
    }
    
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            
        }
       
        return stack2.pop();
    
    }
}
