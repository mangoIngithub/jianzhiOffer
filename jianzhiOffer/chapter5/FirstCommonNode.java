package jianzhioffer.chapter5;
/**题目：输入两个链表，找出它们的第一个公共结点。
 * 思路：本题应该分为三种情况，1.两个链表都无环；下题解法是基于无环的。剑指offer中是第一种，腾讯面试考察了隐含有环链表。
 *          首先这种情形两个链表的连接方式是Y字形，先判断尾结点是否相等，不相等则没有公共节点。并计算每个链表长度。然后长的链表移动长度差值
 *          最后共同移动，直到遇到相等的就是第一个公共结点
 *                      2.一个有环，一个无环；
 *          这种情形两个链表无法相交。因此就是判断是否有环就可以。判断环思路是用两个指针，一个慢速走一步，一个快速走两个，
 *          如果直到有null结点都没有相遇，则没有环，相遇则是有相等也就有环。            
 *                      3.两个都有环
 *          首先判断有环的基础上，找到每个链表的入口结点。
 *          方法：找到环相遇的结点之后，再走一圈，计算出环的长度n。然后用一个指针先移动n，然后与头结点一起移动，直到两个相遇，这个就是环入口
 *          首先判断两链表的环长度是否相等；
 *          找到两个链表入口节点之后，一个快速走两步，一个慢速走一步。注意：终止条件是慢速走完一圈还没相遇 则没有相交。
 *          因为如果在同一个环中，两者的差值不会大于环长度。慢速走的长度就是环长度。
 *          此时返回任意一个环节点入口就可以了。
 * @author lzw
 * @date 2017年12月27日
 * @version version1.0
 */
public class FirstCommonNode {
	   public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		     if(pHead1==null||pHead2==null){
		         return null;
		     }   
		        int cnt1=0;
		        int cnt2=0;
		        ListNode tmpHead1=pHead1;
		         ListNode tmpHead2=pHead2;
		         while(tmpHead1.next!=null){
		             cnt1++;
		            tmpHead1=tmpHead1.next;
		        }
		        while(tmpHead2.next!=null){
		            cnt2++;
		            tmpHead2=tmpHead2.next;
		        }
		        if(tmpHead1!=tmpHead2){
		            return null;
		        }else{
		            if(cnt1-cnt2>=0){
		                int dif=cnt1-cnt2;
		                for(int i=0;i<dif;i++){
		                  pHead1=pHead1.next;  
		                }
		                
		            }else{
		                int dif=cnt2-cnt1;
		                for(int i=0;i<dif;i++){
		                    pHead2=pHead2.next;
		                }
		            }
		            while(pHead1!=pHead2){
		                pHead1=pHead1.next;
		                pHead2=pHead2.next;
		            }
		            return pHead1;
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