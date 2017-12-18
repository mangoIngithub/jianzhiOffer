package jianzhioffer.chapter4;
/**
 * ��Ŀ������һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬
 *      ֻ�ܵ������н��ָ���ָ��
 * ˼·��������������ĵݹ��㷨������һ����־�ڵ㣬���������Զ�λ��������Ľڵ�λ�ã���������
 *      ���޸�ÿ���ڵ���������������־�ڵ����ű���������ջ�������β����
 *       ע�⣺java���û��ָ�룬�������ô���Ҳֻ�Ǹ��Ƹ��������Ϊ�˷��ر�־�ڵ㣬����ȫ�ֱ���
 * @author lzw
 * @date 2017��12��18��
 * @version version1.0
 */
public class TreeConvertLinkedList {
    private TreeNode lastNode=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
     
        ConvertNode(pRootOfTree);
         
        TreeNode headNode=lastNode;
        while(headNode!=null&&headNode.left!=null){
            headNode=headNode.left;
        }
        return headNode;
    }
    public void  ConvertNode(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return;
        }
       TreeNode nodeCurrent=pRootOfTree;
        if(nodeCurrent.left!=null){
            ConvertNode(nodeCurrent.left);
        }
        nodeCurrent.left=lastNode;
        if(nodeCurrent.left!=null){
            lastNode.right=nodeCurrent;
        }
        lastNode=nodeCurrent;
        if(nodeCurrent.right!=null){
              ConvertNode(nodeCurrent.right);
        }
    }
}
