package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 题目：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路 :观察发现每一层都符合后进先出的规律，因此采用栈结构。但是由于输出规律是之字形
 *     采用两个栈，一个负责奇数层，一个负责偶数层。并且添加元素也是奇数层左右，偶数层
 *     右左   
 * @author lzw
 * @date 2017年12月16日
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
