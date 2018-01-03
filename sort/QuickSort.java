package sort;

public class QuickSort {
	/*
	 * 快排：O(nlog2n)，最差为O(n^2)  不稳定排序
	 * 思想：采用分治法，把问题划分为子问题再递归解决，找一个基准位置，把待排序区分为左右两部分
	 * 步骤：1.开始时选一个值，一般为数组的第一个数作为机轴
	 *      2.基于这个值，把数组划分为左右两部分，这个值的位置即为最终位置
	 *      3.递归左右两部分，最终直到每个数组的元素为1
	 */
	private static void quickSort(int[] numsAry,int low,int high) {
		int pivotpos;//基准位置
		if(low<high) {//终止条件，每个数组元素大于一
			pivotpos=partition(numsAry,low,high);
			quickSort(numsAry,low,pivotpos-1);
			quickSort(numsAry,pivotpos+1,high);
		}
		
	}
	
	
	
	
	
	private static int partition(int[] numsAry, int low, int high) {
		int pivot=numsAry[low];
		int i=low;
		int j=high;
		while(i<j) {
			while(i<j&&numsAry[j]>=pivot)--j;
			numsAry[i]=numsAry[j];
			while(i<j&&numsAry[i]<=pivot)++i;
			numsAry[j]=numsAry[i];
		}
		numsAry[i]=pivot;
		
		return i;
	}
	private static void swap(int[] numsAry, int j, int i) {
		  numsAry[j]=numsAry[j]^numsAry[i];
		  numsAry[i]=numsAry[j]^numsAry[i];
		  numsAry[j]=numsAry[j]^numsAry[i];
		}
}
