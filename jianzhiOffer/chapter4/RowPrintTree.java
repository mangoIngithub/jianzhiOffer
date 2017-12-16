package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ�����ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ��
 * ˼·:�����ڹ���������أ�����һ���������洢�ڵ㣬Ȼ��ѭ���ж϶����Ƿ�Ϊ�գ�ֻҪ����������Ϊ�գ�����ӵ����У�ÿ�ε�����ͷ
 *     ������Ϊ�з��д�ӡҪ�����Ҫ�����������
 *     toBePrint������ʾ����Ҫ��ӡ�ĸ�����nextLevel��ʾ��һ��Ҫ��ӡ����
 * @author Administrator
 * @date 2017��12��16��
 * @version version1.0
 */
public class RowPrintTree {
	   ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	        
		    ArrayList<ArrayList<Integer>>  totalValue=new ArrayList<ArrayList<Integer>>();
		        if(pRoot==null){
		            return totalValue;
		        }
		        toPrint(pRoot,totalValue);
		      return totalValue;
		    }
		    void toPrint(TreeNode pRoot,ArrayList<ArrayList<Integer>> tValue){
		        Queue<TreeNode> queue=new LinkedList<TreeNode>();
		        ArrayList<Integer> rowList=new ArrayList<Integer>();
		        queue.offer(pRoot);
		        int toBePrint=1;
		        int nextLevel=0;
		        while(!queue.isEmpty()){
		            TreeNode node=queue.poll();
		            rowList.add(node.val);
		            if(node.left!=null){
		                queue.offer(node.left);
		                nextLevel++;
		            }
		              if(node.right!=null){
		                queue.offer(node.right);
		                nextLevel++;
		            }
		            toBePrint--;
		            if(toBePrint==0){
		                tValue.add(rowList);
		                rowList=new ArrayList<Integer>();
		                toBePrint=nextLevel;
		                nextLevel=0;
		            }
		            
		        }
		    }
}
