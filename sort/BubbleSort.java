package cn.lzw.sort;


/**冒泡排序：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，
 * 			较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * 			时间复杂度O(N^2)，稳定
 * 
 * @author Lin
 *
 */
public class BubbleSort {

	public static void sort(int[] ary) {
		for(int i=ary.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(ary[j]>ary[j+1]) {
					swap(ary,j,j+1);
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
