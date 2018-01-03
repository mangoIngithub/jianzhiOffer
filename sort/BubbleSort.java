package sort;

public class BubbleSort {
	/*冒泡排序 时间复杂度为O（n^2）
	 * 思想：从0位置开始直到最后，相邻两两比较，大的往后，每一次循环都把最大的放到最后的位置
	 * 注意：外循环终止条件是i>0 第一个位置不用比较了
	 * 稳定排序
	 */
	private static void bubbleSort(int[] numsAry) {
	  	for (int i = numsAry.length-1; i >0 ; i--) {
			for (int j = 0; j < i; j++) {
				if(numsAry[j]>numsAry[j+1]) {
					swap(numsAry,j,j+1);
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
