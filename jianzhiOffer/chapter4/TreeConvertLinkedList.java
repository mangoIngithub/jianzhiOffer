package jianzhioffer.chapter4;
/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 *      只能调整树中结点指针的指向。
 * 思路：采用中序遍历的递归算法，定义一个标志节点，利用它可以定位中序遍历的节点位置，并且利用
 *      它修改每个节点的左右走向，这个标志节点随着遍历完成最终会在链表尾部。
 *       注意：java里边没有指针，并且引用传递也只是复制副本，因此为了返回标志节点，定义全局变量
 * @author lzw
 * @date 2017年12月18日
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
