package sort;

public class BinaryInsertSort {
	 /*二分查找插入排序：O（n^2），最好是O(nlogn)
	    * 是直接插入的优化，插入位置的查找从后向前遍历改为二分查找
	    * 稳定排序
	    * 
	    */
		private static void binaryInsertSort(int[] numsAry) {
			for (int i = 0; i < numsAry.length-1; i++) {
				 if (numsAry[i+1]<numsAry[i])
			        {
			            int temp = numsAry[i+1];
			            int insertIndex = binarySearch(numsAry, 0,i+1, numsAry[i+1]);//使用二分查找在有序序列中进行查找，获取插入下标
			            for (int j = i; j>=insertIndex; j--) //移动元素
			            {
			            	numsAry[j + 1] = numsAry[j];   
			            }       
			            numsAry[insertIndex] = temp;    //插入元素
			        }
			}
		}
		
		private static int binarySearch(int[] numsAry,int start,int end,int comp) {
			int middle;
			int middleData;
			while(start<end) {
				middle=(end+start)/2;
				middleData=numsAry[middle];
				if(middleData>comp) {
					end=middle-1;
				}else {
					start=middle+1;
				}
			}
			return start;
			
		}
		
		private static void swap(int[] numsAry, int j, int i) {
			  numsAry[j]=numsAry[j]^numsAry[i];
			  numsAry[i]=numsAry[j]^numsAry[i];
			  numsAry[j]=numsAry[j]^numsAry[i];
			}
}
