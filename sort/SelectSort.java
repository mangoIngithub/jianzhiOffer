package sort;

public class SelectSort {
	/*选择排序：时间复杂度为O（n^2）
	 * 从0与其他位置比，小的就交换，每次循环得到最小的放在前边
	 * 不稳定排序
	 */
	private static void selectSort(int[] numsAry) {
		for (int i = 0; i < numsAry.length; i++) {
			for (int j = i+1; j < numsAry.length; j++) {
				if(numsAry[i]>numsAry[j]) {
					swap(numsAry,i,j);
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
