package jianzhioffer.chapter4;
/**
 * ��Ŀ����ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵ�
 * ˼·��һ����Ҫ�Ǿ���ģ�����ǰ�����������������ı������һ��
 * @author Administrator
 * @date 2017��12��16��
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