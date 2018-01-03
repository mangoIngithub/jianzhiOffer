package jianzhioffer.chapter3;
/**题目：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *      例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 思路：定义一个first节点，它的下一个结点指向头结点，防止一开始就重复。最后返回first.next
 *      定义一个节点Last指向重复节点前一个。一旦重复就把后边的都删除。    
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
     ListNode first=new ListNode(-1);
        first.next=pHead;
     ListNode tmp=pHead;
        ListNode last=first;
     while(tmp!=null && tmp.next != null){
         ListNode next=tmp.next;
         if(next.val==tmp.val){
            int val=tmp.val;
            tmp.next=next.next;
            while(tmp.next!=null&&tmp.next.val==val){
                tmp.next=tmp.next.next;
            }
             last.next=tmp.next;
             tmp=last;
             
             
         }else{
             last=tmp;
            tmp=tmp.next;
         }
         
     }
        return first.next;
    }
}
