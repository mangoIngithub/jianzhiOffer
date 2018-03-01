package cn.lzw.sort;


/**
 * 希尔排序：
 * 			算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d.
 * 			对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
 * 			当增量减到1时，进行直接插入排序后，排序完成。
 * 			时间复杂度 O（Nlog2N），不稳定
 * @author Lin
 *
 */
public class ShellSort {

	public static void sort(int[] ary) {
//		int gap=(int) Math.ceil(ary.length)/2;
//		System.out.println(gap);
		for(int gap=ary.length/2;gap>0;gap/=2) {
			for(int i=ary.length-1;i>=(ary.length-1-gap);i--) {
				for(int j=i;j>=gap;j-=gap) {
					if(ary[j]<ary[j-gap]) {
						swap(ary,j,j-gap);
					}else {
						break;
					}
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
