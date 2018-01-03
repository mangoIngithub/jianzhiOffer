package sort;

public class InsertSort {
	/*插入排序 ：O（n^2）
	 * 假定前边分为已排序，然后取排序后边一个新元素，与前边逐一比对，如果比前小就交换，直到遇到比前大停止
	 * 稳定排序
	 */
	private static void insertSort(int[] numsAry) {
		for (int i = 0; i < numsAry.length-1; i++) {
			for (int j = i+1; j>0; j--) {
				if(numsAry[j]<numsAry[j-1]) {
					swap(numsAry,j,j-1);
				}else {
					break;
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
