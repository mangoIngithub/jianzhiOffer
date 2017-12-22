package jianzhioffer.chapter4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目:求字符串的所有组合，如a、b、c 的组合为a,b,c,ab,ac,bc,abc
 * 思路：求n个字符长度为m的组合，如果组合里包含第一个字符，则在其他字符里找m-1个字符。
 *     如果不包含第一个字符，则在其n-1个字符里找m个字符.
 * @author lzw
 * @date 2017年12月22日
 * @version version1.0
 */
/**
 *  n个元素选m个元素的组合问题的实现. 原理如下:
 *  从后往前选取, 选定位置i后, 再在前i-1个里面选取m-1个.
 *  如: 1, 2, 3, 4, 5 中选取3个元素.
 *  1) 选取5后, 再在前4个里面选取2个, 而前4个里面选取2个又是一个子问题, 递归即可;
 *  2) 如果不包含5, 直接选定4, 那么再在前3个里面选取2个, 而前三个里面选取2个又是一个子问题, 递归即可;
 *  3) 如果也不包含4, 直接选取3, 那么再在前2个里面选取2个, 刚好只有两个.
 *  纵向看, 1与2与3刚好是一个for循环, 初值为5, 终值为m.
 *  横向看, 该问题为一个前i-1个中选m-1的递归.
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
