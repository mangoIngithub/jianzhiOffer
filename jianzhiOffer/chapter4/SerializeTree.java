package jianzhioffer.chapter4;
/**
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路：序列化思路采用前序遍历，遇到空就赋值"$"，并且用","隔开，形成序列化字符串。注意逗号的添加位置，每次操作后都加
 *      反序列化采用前序遍历的思路递归，注意由于java是副本引用，所以反序列函数必须是返回TreeNode然后赋值给root。
 *      注意索引++的位置，每次操作后都加
 * @author lzw
 * @date 2017年12月21日
 * @version version1.0
 */
public class SerializeTree {
	 String Serialize(TreeNode root) {
		    if(root==null){
		        return "$";
		    }
		        String str=root.val+",";
		        str+=Serialize(root.left)+",";
		        str+=Serialize(root.right)+",";
		        return str;
		  }
		    TreeNode Deserialize(String str) {
		       String[] result=str.split(",");
		        TreeNode root=null;
		        int[] index={0};
		       root= deserialize(root,result,index);
		        return root;
		      }
		    TreeNode deserialize(TreeNode root,String[] result,int[] index){
		        if(index[0]>=result.length){
		            return null;
		        }
		        if(!result[index[0]].equals("$")){
		            root=new TreeNode(Integer.valueOf(result[index[0]]));
		            ++index[0];
		            root.left=deserialize(root.left,result,index);
		              ++index[0];
		            root.right=deserialize(root.right,result,index);
		             ++index[0];
		        } 
		        return root;
		    }
}
