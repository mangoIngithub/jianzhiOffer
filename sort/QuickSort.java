package cn.lzw.sort;


/**快排思想：	
 * 		基于分治的思想，是冒泡排序的改进型。首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，一般是选取第一个，优化可以三数排序取第一个），
 * 		然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，如果发现有元素比该基准点的值小，
 * 		就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。
 * 		一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。	
 * 		时间复杂度O（NlogN） 不稳定
 * @author Lin
 *
 */
public class QuickSort {

	public static void sort(int[] ary) {
		if(ary.length>0) {
			quickSort(ary,0,ary.length-1);
		}
	}
	
	
	private static void quickSort(int[] ary, int low, int high) {
		if(low<high) {
			int mid=partition(ary,low,high);
			quickSort(ary,low,mid-1);
			quickSort(ary,mid+1,high);
		}
		
	}


	private static int partition(int[] ary, int low, int high) {
		int key=ary[low];
		while(low<high) {
			while(low<high&&key<=ary[high]) {
				high--;
			}
			ary[low]=ary[high];
			while(low<high&&ary[low]<=key) {
				low++;
			}
			ary[high]=ary[low];
		}
		ary[high]=key;
		return high;
	}


	public static void swap(int[] ary,int i,int j) {
		ary[i]=ary[i]^ary[j];
		ary[j]=ary[i]^ary[j];
		ary[i]=ary[i]^ary[j];
	}
}
