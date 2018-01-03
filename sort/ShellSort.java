package sort;

public class ShellSort {
	/*希尔排序 O（nlogn）
	 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
	 * 当增量减至1时，整个文件恰被分成一组，算法便终止，选择增量gap=length/2
	 * 不稳定排序
	 */
	private static void shellSort(int[] numsAry) {
	  for(int gap=numsAry.length/2;gap>0;gap/=2) {
		  for(int i=gap;i<numsAry.length;i++) {
			  int j=i;
			  while(j-gap>=0&&numsAry[j]<numsAry[j-gap]) {
				  swap(numsAry,j,j-gap);
				  j-=gap;
			  }
		  }
	  }
	}
	private static void swap(int[] numsAry, int j, int i) {
		  numsAry[j]=numsAry[j]^numsAry[i];
		  numsAry[i]=numsAry[j]^numsAry[i];
		  numsAry[j]=numsAry[j]^numsAry[i];
		}
}
