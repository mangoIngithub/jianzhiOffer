package jianzhioffer.chapter3;
/**
 * 题目：一个链表中包含环，请找出该链表的环的入口结点。
 * 思路:1.meetingNode函数用于找到环中的某个节点，定义一个快节点走两步，一个慢节点走一步，如果有环，则两点会相遇在环中，没有
 *       环，则快节点先遇到空
 *     2.找到环节点的话，可以统计环中节点数n
 *     3.定义两个节点，一个节点在头节点，一个先走n步，然后同种速度往前走，最终会在环入口相遇。
 *     注意 第三步的起点必须是头结点，也就是头结点也有东西
 * 
 * @author Administrator
 * @date 2017年12月16日
 * @version version1.0
 */
public class EntryLinkListLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        
     ListNode meetNode=meetingNode(pHead);
        if(meetNode==null){
            return null;
        }
        int loopNum=0;
        ListNode moveNode=meetNode.next;
        while(true){
            loopNum++;
            if(moveNode==meetNode){
                break;
            }
            moveNode=moveNode.next;
        }
        ListNode p1=pHead;
        ListNode p2=pHead;
        for(int i=0;i<loopNum;i++){
            p2=p2.next;
        }
        while(true){
            if(p1==p2){
               break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    public ListNode meetingNode(ListNode pHead){
        if(pHead==null){
            return null;
        }
        ListNode slowNode=pHead.next;
        if(slowNode==null){
            return null;
        }
        ListNode fastNode=slowNode.next;
        while(fastNode!=null&&slowNode!=null){
            if(fastNode==slowNode){
                return fastNode;
            }
            slowNode=slowNode.next;
            fastNode=fastNode.next;
            if(fastNode!=null){
                fastNode=fastNode.next;
            }
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}