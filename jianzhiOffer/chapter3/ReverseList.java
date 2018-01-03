package jianzhioffer.chapter3;
/**题目：输入一个链表，反转链表后，输出翻转链表的头结点。
 * 思路：需要定义三个节点，前节点，当前节点。回转后的头结点。回转后的头结点就是原尾结点。
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        
        ListNode cur=head;
     ListNode preCur=null;
     ListNode headCur=null;
     while(cur!=null){
        ListNode nextCur=cur.next;
         if(nextCur==null){
             headCur=cur;
         }
         cur.next=preCur;
         preCur=cur;
         cur=nextCur;
     } 
        return headCur;
    }
}
