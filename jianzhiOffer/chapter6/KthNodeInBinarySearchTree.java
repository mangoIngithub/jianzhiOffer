package jianzhioffer.chapter6;
/**题目:给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 思路：由于是二叉搜素树，中序遍历即可得到按大小排序的节点。并且采用数组参数，用来从第一个值才--。
 *      注意，为了使找到第K个位置就不再递归时，采用node==null来判定。每当node==null k--,并且递归下去。直到k==1 把该节点赋值node
 *      
 * 
 * @author lzw
 * @date 2018年1月1日
 * @version version1.0
 */
public class KthNodeInBinarySearchTree {
	  TreeNode KthNode(TreeNode pRoot, int k)
	    {
	       if(pRoot==null||k<1){
	           return null;
	       }
	        int[] kAry={k};
	        return KthNodeCore(pRoot,kAry);
	    }
	    TreeNode KthNodeCore(TreeNode pRoot,int[] kAry){
	        TreeNode node=null;
	        if(pRoot.left!=null){
	            node=KthNodeCore(pRoot.left,kAry);
	        }
	        if(node==null){
	            if(kAry[0]==1){
	                node=pRoot;
	            }
	            kAry[0]--;
	        }
	        if(node==null&&pRoot.right!=null){
	            node=KthNodeCore(pRoot.right,kAry);
	        }
	        return node;
	        
	    }

}
