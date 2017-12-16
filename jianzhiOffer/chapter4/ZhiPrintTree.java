package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.Stack;
/**
 * ��Ŀ����ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 *      �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * ˼· :�۲췢��ÿһ�㶼���Ϻ���ȳ��Ĺ��ɣ���˲���ջ�ṹ�������������������֮����
 *     ��������ջ��һ�����������㣬һ������ż���㡣�������Ԫ��Ҳ�����������ң�ż����
 *     ����   
 * @author lzw
 * @date 2017��12��16��
 * @version version1.0
 */
public class ZhiPrintTree {
	  public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		    ArrayList<ArrayList<Integer>> totalValue=new ArrayList<ArrayList<Integer>>();
		        if(pRoot==null){
		            return totalValue;
		        }
		        toPrint(pRoot,totalValue);
		        return totalValue;
		    }
		   void toPrint(TreeNode pRoot,ArrayList<ArrayList<Integer> > tValue){
		       int layer=1;
		       Stack<TreeNode> s1=new Stack<TreeNode>();
		       Stack<TreeNode> s2=new Stack<TreeNode>();
		       s1.push(pRoot);
		       while(!s1.empty()||!s2.empty()){
		           if((layer&1)==1){
		               ArrayList<Integer> rowList=new ArrayList<Integer>();
		               while(!s1.empty()){
		                   TreeNode node =s1.pop();
		                   rowList.add(node.val);
		                   if(node.left!=null){
		                       s2.push(node.left);
		                   }
		                   if(node.right!=null){
		                       s2.push(node.right);
		                   }
		               }
		               tValue.add(rowList);
		               layer++;
		           }else{
		                ArrayList<Integer> rowList=new ArrayList<Integer>();
		                 while(!s2.empty()){
		                   TreeNode node =s2.pop();
		                   rowList.add(node.val);
		                   if(node.right!=null){
		                       s1.push(node.right);
		                   }
		                     if(node.left!=null){
		                       s1.push(node.left);
		                   }
		               }
		               tValue.add(rowList);
		               layer++;
		           }
		           
		       }
		           
		           
		       
		   }
}
