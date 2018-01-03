package jianzhioffer.chapter2;
/**题目：给定二叉树的前序遍历和中序遍历数组，要求重建二叉树
 * 思路：因为前序遍历的每个节点都是中节点，因此若找到对应中序遍历的位置，左边即为左子树，右边即为右子树。
 *      每次都重新定位各索引位置，因此采用递归思想。
 *      注意递归函数的参数，是前序，前序开始索引，前序终止索引，中序，中序开始索引，中序终止索引。
 *      并且，有左子树就是leftLength>0,有右子树就是leftLength<preEnd-preStart
 *      特殊测试，前序和中序不匹配。因此当遍历完中序也找不到对应的索引，就要抛出异常
 *      
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class ReConstructBinaryTree {
	  public TreeNode reConstructBinaryTree(int [] pre,int [] in)throws Exception {
	        if(pre==null||in==null||pre.length<1||in.length<1){
	            return null;
	        }
	        return reConstructBinaryTreeCore(pre,0,pre.length-1,in,0,in.length-1);
	    }
	    public TreeNode reConstructBinaryTreeCore(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd)throws Exception{
	      TreeNode node=new TreeNode(pre[preStart]);
	      node.left=null;
	      node.right=null;
	       int rootIndex=inStart;
	        while(rootIndex<=inEnd&&in[rootIndex]!=pre[preStart]){
	            rootIndex++;
	        }
	     
	            if(rootIndex==inEnd&&in[rootIndex]!=pre[preStart]){
	            throw new Exception("invalid input");
	        }
	       
	       int leftLength=rootIndex-inStart;
	       if(leftLength>0){
	          node.left= reConstructBinaryTreeCore(pre,preStart+1,preStart+leftLength,in,inStart,rootIndex-1);
	       }
	        if(leftLength<preEnd-preStart){
	           node.right= reConstructBinaryTreeCore(pre,preStart+leftLength+1,preEnd,in,rootIndex+1,inEnd);
	        }
	      return node;
	     }
}

 class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 