package jianzhioffer.chapter6;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
/**题目：如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 *      他们的最大值分别为{4,4,6,6,6,5}；
 * 思路：采用双端队列。队列的队头一直是当前窗口的最大值，一旦队尾的数比输入的数小，
 *      就从队尾弹出，最后把数字压入。如果队尾的数比较大，就直接压入。
 *      为了避免输入的数超过窗口。因此队列存的是数组下标。每次都比较队头的下标值与当前的
 *      下标值差若大于等于窗口大小，就去除队头。
 *      当下标值大于等于size-1，就开始把队头对应的数组值添加到列表中
 * @author lzw
 * @date 2017年12月30日
 * @version version1.0
 */
public class MaxNumInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(num.length>=size&&size>=1){
            Deque<Integer> deque=new LinkedList<Integer>();
            
            for(int i=0;i<num.length;i++){
             if(deque.isEmpty()){
                 deque.addLast(i);
                      if(i>=size-1){
                 list.add(num[deque.peekFirst()]);
             
                 
             }
             }else{
                 if(i-deque.peekFirst()>=size){
                      deque.pollFirst(); 
                 }
               while(!deque.isEmpty()&&num[deque.peekLast()]<num[i]){
                   deque.pollLast();
               }
                 deque.addLast(i);
                if(i>=size-1){
                 list.add(num[deque.peekFirst()]);
             
                 
             }
             }
           
            }
        }
        return list;
    }
}
