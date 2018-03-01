package cn.lzw.sort;


/**
 * 选择排序：
 * 			在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 			然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * 			时间复杂度
 * @author Lin
 *
 */
public class SelectSort {

	public static void sort(int[] ary) {
		for (int i = 0; i < ary.length-1; i++) {
			for(int j=i+1;j<ary.length;j++) {
				if(ary[i]>ary[j]) {
					swap(ary,i,j);
				}
			}
		}
		
		
	}
	
	
	public static void swap(int[] ary,int i,int j) {
		ary[i]=ary[i]^ary[j];
		ary[j]=ary[i]^ary[j];
		ary[i]=ary[i]^ary[j];
	}
}
