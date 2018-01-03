package jianzhioffer.chapter3;
/**题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：递归思想，首先A的节点跟B的节点值若一样，就进入另个判断整个结构是否一样的函数。此函数也是递归调用，一旦到B的子节点就返回true
 *      如果一有值不同或者A到叶子结点就返回false,或者继续左右递归。保证所有节点都一致，
 *      一旦一开始不一样，就递归A的左右节点。最终返回result
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class AHasBSubTree {
	   public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	         boolean result=false;
	        if(root1!=null&&root2!=null){
	            if(root1.val==root2.val){
	                result=doesTreeHaveTree2(root1,root2);
	            }
	            if(!result){
	                result=HasSubtree(root1.left,root2);
	            }
	            if(!result){
	                result=HasSubtree(root1.right,root2);
	            }
	        }
	        return result;
	        
	        
	    }
	    private boolean doesTreeHaveTree2(TreeNode root1,TreeNode root2){
	        if(root2==null){
	            return true;
	        }
	        if(root1==null){
	            return false;
	        }
	        if(root1.val!=root2.val){
	            return false;
	        }
	        
	        return doesTreeHaveTree2(root1.left,root2.left)&&doesTreeHaveTree2(root1.right,root2.right);
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