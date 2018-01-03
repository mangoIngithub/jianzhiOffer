package sort;

public class MergeSort {

	/*
	 * 归并算法：时间复杂度都是O(nlog2n),但空间复杂度为O（n） 稳定排序
	 * 思想：1.分，递归把数组分裂成一个元素
	 *     2.合并，在递归完后进行比较合并，逐一移动下标，放入临时数组
	 * 
	 */
			
	
	private static void mergeSort(int[] numsAry) {
		int[] temp=new int[numsAry.length];
		sort(0,numsAry.length-1,numsAry,temp);
	}
	
	
	
	
	private static void sort(int left, int right, int[] numsAry, int[] temp) {
      if(left<right) {
    	  int mid=(left+right)/2;
    	  sort(left,mid,numsAry,temp);
    	  sort(mid+1,right,numsAry,temp);
    	  merge(left,mid,right,numsAry,temp);
      }
		
		
	}
	private static void merge(int left, int mid, int right, int[] numsAry, int[] temp) {
       int i=left;
       int j=mid+1;
       int t=0;
		while(i<=mid&&j<=right) {
			if(numsAry[i]<=numsAry[j]) {
				temp[t++]=numsAry[i++];
			}else {
				temp[t++]=numsAry[j++];
			}
		}
		while(i<=mid) {
			temp[t++]=numsAry[i++];//把剩余的左边序列放到临时数组中
		}
		while(j<=right) {
			temp[t++]=numsAry[j++];//把剩余的右边边序列放到临时数组中
		}
		t=0;
		while(left<=right) {
			numsAry[left++]=temp[t++];
		}
		
	}
	private static void swap(int[] numsAry, int j, int i) {
	  numsAry[j]=numsAry[j]^numsAry[i];
	  numsAry[i]=numsAry[j]^numsAry[i];
	  numsAry[j]=numsAry[j]^numsAry[i];
	}

}
