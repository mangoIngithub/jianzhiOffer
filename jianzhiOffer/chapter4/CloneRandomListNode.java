package jianzhioffer.chapter4;

import java.util.HashMap;
/**
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为
 *      复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路1：分为两步，1步按链表顺序克隆新的节点<N,N'>，并存放在一个哈希表中；2步再次遍历链表， 每个
 *      节点的随机结点S',都可以通过哈希表的S来获取。最终达到克隆目的。
 *      时间复杂度O(N)，空间复杂度O(N)
 * 思路2：分为3步，1步克隆节点N'，然后链接在节点N后边
 *             2步克隆随机结点S',就是N->S后边的节点
 *             3步按奇偶拆分链表
 *             时间复杂度为O(N)，空间复杂度为O(1)
 *   
 * @author lzw
 * @date 2017年12月17日
 * @version version1.0
 */
public class CloneRandomListNode {
	/*   思路1
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
	
	//思路2：
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