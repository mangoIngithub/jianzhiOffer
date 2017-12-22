package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 题目:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *     则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 思路:分为两步，1.首先把第一个字符和后边字符分成两部分，第一个字符分别与后边每个字符交换
 *            2.一旦交换其中一次，然后又可以把第二个字符和后边每个字符交换
 *      这样就可以得到全排列，注意添加的时候确保集合里没有
 *      最后用工具对集合排序得到字典序 
 * @author lzw
 * @date 2017年12月22日
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
