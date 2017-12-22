package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ��Ŀ:���ַ�����������ϣ���a��b��c �����Ϊa,b,c,ab,ac,bc,abc
 * ˼·����n���ַ�����Ϊm����ϣ��������������һ���ַ������������ַ�����m-1���ַ���
 *     �����������һ���ַ���������n-1���ַ�����m���ַ�.
 * @author lzw
 * @date 2017��12��22��
 * @version version1.0
 */
/**
 *  n��Ԫ��ѡm��Ԫ�ص���������ʵ��. ԭ������:
 *  �Ӻ���ǰѡȡ, ѡ��λ��i��, ����ǰi-1������ѡȡm-1��.
 *  ��: 1, 2, 3, 4, 5 ��ѡȡ3��Ԫ��.
 *  1) ѡȡ5��, ����ǰ4������ѡȡ2��, ��ǰ4������ѡȡ2������һ��������, �ݹ鼴��;
 *  2) ���������5, ֱ��ѡ��4, ��ô����ǰ3������ѡȡ2��, ��ǰ��������ѡȡ2������һ��������, �ݹ鼴��;
 *  3) ���Ҳ������4, ֱ��ѡȡ3, ��ô����ǰ2������ѡȡ2��, �պ�ֻ������.
 *  ����, 1��2��3�պ���һ��forѭ��, ��ֵΪ5, ��ֵΪm.
 *  ����, ������Ϊһ��ǰi-1����ѡm-1�ĵݹ�.
 */
public class StrAllCombination {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		ArrayList<String> allList=new ArrayList<>();
	    int length=str.length();
	    char[] subChars=new char[length];
	    for(int m=1;m<=length;m++) {
	    	combination(str.toCharArray(),allList,subChars,length,m,m);
	    }
	    for(String str1:allList) {
	    	System.out.println(str1);
	    }
		 
	}

	private static void combination(char[] charArray, ArrayList<String> allList, char[] subChars, int length, int m,
			int m2) {
           if(m2==0) {
        	   String sub=String.valueOf(subChars);
        	   sub=sub.substring(0, m);
        	   allList.add(sub);
           }else {
        	   for(int i=length;i>=m2;i--) {
        		   subChars[m2-1]=charArray[i-1];
        		   combination(charArray,allList,subChars,i-1,m,m2-1);
        	   }
           }
	}
}
