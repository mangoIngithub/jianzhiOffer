package jianzhioffer.chapter3;
/**题目：输入一个链表，输出该链表中倒数第k个结点。
 * 思路：构建两个指针，c1先走k步，然后c2再开始走，一直走到c1为null，此时c2为倒数第k个节点
 *     注意：因为终止条件为c1空，所以c1走k步，如果是c1.next空就只走k-1步
 *     特殊输入，k<1或者head为空，或者！cnt<k c1就为空了。都返回空
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class ListLastKNode {
	   public ListNode FindKthToTail(ListNode head,int k) {
	        if(k<1||head==null){
	            return null;
	        }
	    /* ListNode source=head;
	        int cnt=0;
	        while(source!=null){
	            cnt++;
	            source=source.next;
	        }
	       if(cnt<k){
	           return null;
	       } 
	       for(int i=0;i<cnt-k;i++){
	           head=head.next;
	       }
	          return head;
	          */
	       ListNode cur1=head;
	       ListNode cur2=head;
	       int cnt=0;
	        while(cur1!=null){
	            if(cnt>=k){
	                cur2=cur2.next;
	                cur1=cur1.next;
	            }else{
	                cur1=cur1.next;
	            }
	            cnt++;
	        }
	        if(cnt<k){
	            return null;
	        }
	        return cur2;
	    }
}
