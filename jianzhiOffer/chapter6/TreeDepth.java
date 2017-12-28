package jianzhioffer.chapter6;
/**题目：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路：因为如果一颗树结点，都没有子树，则深度为1，若有左子树而没有右子树，则深度为右子树的深度加1，反之同理。
 * @author lzw
 * @date 2017年12月28日
 * @version version1.0
 */
public class TreeDepth {
	   public int TreeDepth(TreeNode root) {
	        return firstVisit(root);
	    }
	    public int firstVisit(TreeNode node){
	     if(node==null){
	         return 0;
	     }
	        
	     int   left=firstVisit(node.left);
	     int  right=firstVisit(node.right);
	        
	        return (left>right)?left+1:right+1;
	    }
}
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}