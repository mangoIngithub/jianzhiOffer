package cn.lzw.sort;
/**直接插入排序：
 * 			在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排

			好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数

			也是排好顺序的。如此反复循环，直到全部排好顺序。
			时间复杂度N^2,稳定
 * 
 * @author Lin
 *
 */
public class InsertSort {

	
	public static void sort(int[] ary) {
		for(int i=0;i<ary.length;i++) {
			for(int j=i;j>0;j--) {
				if(ary[j]<ary[j-1]) {
					swap(ary,j,j-1);
				}else {
					break;
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
