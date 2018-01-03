package jianzhioffer.chapter3;
/**题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 思路：构建一个空节点p，首先比较两个链表的头结点值，哪个小，就把它赋给空节点。接着继续比较小的下一个结点
 *     与另个链表头结点，返回值赋给p.next。发现是递归过程。直到某个节点为空，就把另个链表返回就可以。最后返回p
 *    
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class MergeTwoList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
         ListNode mergeHead=null;
           if(list1.val<=list2.val){
               mergeHead=list1;
               mergeHead.next=Merge(list1.next,list2);
           }else{
               mergeHead=list2;
               mergeHead.next=Merge(list1,list2.next);
           }
           return mergeHead;
       }
}
