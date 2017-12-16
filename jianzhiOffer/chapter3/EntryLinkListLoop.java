package jianzhioffer.chapter3;
/**
 * ��Ŀ��һ�������а����������ҳ�������Ļ�����ڽ�㡣
 * ˼·:1.meetingNode���������ҵ����е�ĳ���ڵ㣬����һ����ڵ���������һ�����ڵ���һ��������л���������������ڻ��У�û��
 *       �������ڵ���������
 *     2.�ҵ����ڵ�Ļ�������ͳ�ƻ��нڵ���n
 *     3.���������ڵ㣬һ���ڵ���ͷ�ڵ㣬һ������n����Ȼ��ͬ���ٶ���ǰ�ߣ����ջ��ڻ����������
 *     ע�� ����������������ͷ��㣬Ҳ����ͷ���Ҳ�ж���
 * 
 * @author Administrator
 * @date 2017��12��16��
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