package jianzhioffer.chapter4;
/**
 * 题目：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 * 思路：一个树要是镜像的，它的前序遍历结果会和中右左的遍历结果一致
 * @author Administrator
 * @date 2017年12月16日
 * @version version1.0
 */
public class isSymmetricalClass {
	 boolean isSymmetrical(TreeNode pRoot)
	    {
	    return isSymmetricals(pRoot,pRoot);
	        
	    }
	    boolean isSymmetricals(TreeNode pRoot,TreeNode pRoot1){
	        if(pRoot==null&&pRoot1==null){
	            return true;
	        }
	         if(pRoot==null||pRoot1==null){
	            return false;
	        }
	        if(pRoot.val!=pRoot1.val){
	            return false;
	        }
	        return isSymmetricals(pRoot.left,pRoot1.right)&&isSymmetricals(pRoot.right,pRoot1.left);
	        
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