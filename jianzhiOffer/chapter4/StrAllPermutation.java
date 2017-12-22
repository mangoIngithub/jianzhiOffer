package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.Collections;
/**
 * ��Ŀ:����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
 *     ���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * ˼·:��Ϊ������1.���Ȱѵ�һ���ַ��ͺ���ַ��ֳ������֣���һ���ַ��ֱ�����ÿ���ַ�����
 *            2.һ����������һ�Σ�Ȼ���ֿ��԰ѵڶ����ַ��ͺ��ÿ���ַ�����
 *      �����Ϳ��Եõ�ȫ���У�ע����ӵ�ʱ��ȷ��������û��
 *      ����ù��߶Լ�������õ��ֵ��� 
 * @author lzw
 * @date 2017��12��22��
 * @version version1.0
 */
public class StrAllPermutation {
	 public ArrayList<String> Permutation(String str) {
	       
	        ArrayList<String> list=new ArrayList<>();
	        if(str.length()<=0||str==null){
	           return list;
	       }
	        Permutation(str.toCharArray(),list,0);
	        if(list.size()!=0){
	            Collections.sort(list);
	        }
	        return list;
	    }
	    public void Permutation(char[] ary,ArrayList<String> list,int begin){
	        if(begin==ary.length-1){
	            String str=String.valueOf(ary);
	            if(!list.contains(str)){
	                list.add(str);
	            }
	        }else{
	            for(int i=begin;i<ary.length;i++){
	                swap(ary,i,begin);
	                Permutation(ary,list,begin+1);
	                swap(ary,i,begin);
	            }
	        }
	    }
	    public void swap(char[] ary,int i,int begin){
	        char temp=ary[i];
	        ary[i]=ary[begin];
	        ary[begin]=temp;
	        
	        
	    }
}
