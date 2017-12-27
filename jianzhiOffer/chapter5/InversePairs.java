package jianzhioffer.chapter5;
/**题目：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *      输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
                    输入描述:
                    题目保证输入的数组中没有的相同的数字
                    数据范围：
	             对于%50的数据,size<=10^4
	             对于%75的数据,size<=10^5
 * 思路： 利用归并算法，把数组递归分成左右两个子数组。比较左右数组，一旦左比右大，则有逆序对就是右边当前指针到中点的个数。
 *      归并算法要利用辅助数组。
 * @author lzw
 * @date 2017年12月27日
 * @version version1.0
 */

import java.util.Scanner;

public class InversePairs {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    String str=sc.nextLine();
	    String[] strAry=str.split("\\s+");
	    int[] ary=new int[strAry.length];
	    for (int i = 0; i < ary.length; i++) {
			ary[i]=Integer.valueOf(strAry[i]);
		}
	    int t=InversePairs(ary);
	    System.out.println(t);
	}
	 public static int InversePairs(int [] array) {
	     if(array.length<=0) {
	    	 return 0;
	     }
		 int[] tmp=new int[array.length];
		 int t=sort(0,array.length-1,array,tmp);
		 
		 return t;
	    }
	 
	 public static int sort(int start,int end,int[] ary,int[] tmp) {
		 int t=0;
		 if(start<end) {
			 int mid=(start+end)/2;
			 t+=sort(start,mid,ary,tmp);
			 t+=sort(mid+1,end,ary,tmp);
			 t+=merge(start,mid,end,ary,tmp);
		 }
		 return t;
	 }

	private static int merge(int start, int mid, int end, int[] ary, int[] tmp) {
		int index=end,t=0;
		int i=mid;
		int j=end;
		while(i>=start&&j>=mid+1) {
			if(ary[i]>ary[j]) {
				t+=j-mid;
				tmp[index--]=ary[i--];
			}else {
				tmp[index--]=ary[j--];
			}
		}
		while(i>=start) {
			tmp[index--]=ary[i--];  //把剩余的左序列放到辅助数组
		}
		while(j>=mid+1) {
			tmp[index--]=ary[j--];//把剩余的右序列放到辅助数组
		}
		index=end;
		while(start<=end) {
			ary[end--]=tmp[index--];  //注意等于号
		}
		return t;
	}
}
