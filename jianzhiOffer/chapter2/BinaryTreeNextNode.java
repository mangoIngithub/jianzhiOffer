package jianzhioffer.chapter2;
/**题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *       注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路：1.首先判断有没有右子树。有的话 递归找到右子树对应的第一个左子树，如果没有就返回当前的右子树。
 *        没有的话。递归找到第一个是爸爸的左子树，有的话返回爸爸。没有的话就返回null
 * @author lzw
 * @date 2018年1月1日
 * @version version1.0
 */
public class BinaryTreeNextNode {
	   public TreeLinkNode GetNext(TreeLinkNode pNode)
	    {
	      if(pNode==null){
	          return null;
	      }
	        if(pNode.right!=null){
	            return getLeftSon(pNode.right);
	        }else{
	           return getLeftFather(pNode);
	        }
	    }
	    public TreeLinkNode getLeftSon(TreeLinkNode node){
	        TreeLinkNode left=node.left;
	        if(left==null){
	            return node;
	        }else{
	            return getLeftSon(left);
	        }
	        
	    }
	    
	    public TreeLinkNode getLeftFather(TreeLinkNode node){
	        TreeLinkNode father=node.next;
	        if(father==null){
	            return null;
	        }
	        if(node==father.left){
	            return father;
	        }else{
	            return getLeftFather(father);
	        }
	    }
}
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}