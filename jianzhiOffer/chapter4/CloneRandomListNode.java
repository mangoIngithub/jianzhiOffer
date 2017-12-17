package jianzhioffer.chapter4;

import java.util.HashMap;
/**
 * ��Ŀ������һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ
 *      ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * ˼·1����Ϊ������1��������˳���¡�µĽڵ�<N,N'>���������һ����ϣ���У�2���ٴα������� ÿ��
 *      �ڵ��������S',������ͨ����ϣ���S����ȡ�����մﵽ��¡Ŀ�ġ�
 *      ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(N)
 * ˼·2����Ϊ3����1����¡�ڵ�N'��Ȼ�������ڽڵ�N���
 *             2����¡������S',����N->S��ߵĽڵ�
 *             3������ż�������
 *             ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1)
 *   
 * @author lzw
 * @date 2017��12��17��
 * @version version1.0
 */
public class CloneRandomListNode {
	/*   ˼·1
	 public RandomListNode Clone(RandomListNode pHead)
	    {
	        if(pHead==null){
	            return null;
	        }
	        HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
	        RandomListNode cHead=new RandomListNode(pHead.label);
	        map.put(pHead,cHead);
	        RandomListNode cTemp=cHead;
	        RandomListNode pTemp=pHead;
	        while(pTemp.next!=null){
	            pTemp=pTemp.next;
	            RandomListNode cNext=new RandomListNode(pTemp.label);
	            cTemp.next=cNext;
	            cTemp=cTemp.next;
	            map.put(pTemp,cTemp);
	        }
	        
	        RandomListNode cTemp1=cHead;
	        RandomListNode pTemp1=pHead;
	        while(cTemp1!=null){
	            cTemp1.random=map.get(pTemp1.random);
	            cTemp1=cTemp1.next;
	            pTemp1=pTemp1.next;
	        }
	        return cHead;
	    }
	    */
	
	//˼·2��
	public RandomListNode Clone(RandomListNode pHead)
    {if(pHead==null){
        return null;
    }
    cloneNodes(pHead);
     cloneRandom(pHead);
     return decompose(pHead);
    }
    void cloneNodes(RandomListNode pHead){
        RandomListNode pTemp=pHead;
        while(pTemp!=null){
            RandomListNode cNode=new RandomListNode(pTemp.label);
            cNode.next=pTemp.next;
            pTemp.next=cNode;
            pTemp=cNode.next;
        }
    }
    void cloneRandom(RandomListNode pHead){
        RandomListNode pTemp=pHead;
        while(pTemp!=null){
            RandomListNode cNode=pTemp.next;
            if(pTemp.random!=null){
                cNode.random=pTemp.random.next;
            }
            pTemp=cNode.next;
        }
    }
   RandomListNode decompose(RandomListNode pHead){
       RandomListNode pTemp=pHead;
       RandomListNode cHead=pHead.next;
       RandomListNode cTemp=cHead;
       while(pTemp!=null){
           pTemp.next=cTemp.next;
           pTemp=pTemp.next;
           if(pTemp==null){
               cTemp.next=null;
           }else{
               cTemp.next=pTemp.next;}
           cTemp=cTemp.next;
           
       }
       return cHead;
   }
}
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}