package jianzhioffer.chapter2;

import java.util.ArrayList;
/**题目：输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：利用栈或者递归
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class PrintListFromTailToHead {
    /*
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
    */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
         ArrayList<Integer> list=new ArrayList<Integer>();
        recursionList(list,listNode);
        return list;
        
    }
    
    public void recursionList( ArrayList<Integer> list,ListNode node){
        if(node!=null){
            recursionList(list,node.next);
            list.add(node.val);
        }
    }
}
 class ListNode {
      int val;
       ListNode next = null;

     ListNode(int val) {
           this.val = val;
       }
   }