package jianzhioffer.chapter4;
/**
 * ��Ŀ����ʵ�������������ֱ��������л��ͷ����л�������
 * ˼·�����л�˼·����ǰ������������վ͸�ֵ"$"��������","�������γ����л��ַ�����ע�ⶺ�ŵ����λ�ã�ÿ�β����󶼼�
 *      �����л�����ǰ�������˼·�ݹ飬ע������java�Ǹ������ã����Է����к��������Ƿ���TreeNodeȻ��ֵ��root��
 *      ע������++��λ�ã�ÿ�β����󶼼�
 * @author lzw
 * @date 2017��12��21��
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
