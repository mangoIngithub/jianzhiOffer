package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 * 思路:类似于广度优先搜素，利用一个队列来存储节点，然后循环判断队列是否为空，只要左右子树不为空，就添加到队列，每次弹出队头
 *     但是因为有分行打印要求，因此要多加两个变量
 *     toBePrint用来表示还有要打印的个数，nextLevel表示下一层要打印的数
 * @author Administrator
 * @date 2017年12月16日
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
