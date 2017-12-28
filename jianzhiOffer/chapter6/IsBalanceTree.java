package jianzhioffer.chapter6;
/**题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路：平衡二叉树的定义是 左右子树的深度差不超过1
 *      因此，首先计算每个结点的深度，一旦深度差超过1，就返回-1代表false，并且一直返回-1。
 * 
 * @author lzw
 * @date 2017年12月28日
 * @version version1.0
 */
public class IsBalanceTree {
	public class Solution {
	    
	    public boolean IsBalanced_Solution(TreeNode root) {
	        
	         int depth=Visit(root);
	        if(depth==-1){
	            return false;
	        }else{
	            return true;
	        }
	        
	    }
	    public int Visit(TreeNode node){
	       if(node==null){
	           return 0;
	       }
	        int left=Visit(node.left);
	        if(left==-1){
	            return -1;
	        }
	        int right=Visit(node.right);
	          if(right==-1){
	            return -1;
	        }
	        if(right-left>1||right-left<-1){
	            return -1;
	        }
	        return (left>right)?left+1:right+1;
	    }
	}
}
