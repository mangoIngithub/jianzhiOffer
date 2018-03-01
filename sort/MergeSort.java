package cn.lzw.sort;


/**归并排序：
 * 			归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 			即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 			O（NlogN）稳定
 * 
 * @author Lin
 *
 */
public class MergeSort {

	public static void sort(int[] ary) {
		if(ary.length>0) {
			int[] tmp=new int[ary.length];
			sort(ary,0,ary.length-1,tmp);
		}
	}
	
	
	private static void sort(int[] ary, int low, int high,int[] tmp) {
		if(low<high) {
			int mid=(low+high)/2;
			sort(ary,low,mid,tmp);
			sort(ary,mid+1,high,tmp);
			merge(ary,low,mid,high,tmp);
		}
	}


	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
		
	}


	public static void swap(int[] ary,int i,int j) {
		ary[i]=ary[i]^ary[j];
		ary[j]=ary[i]^ary[j];
		ary[i]=ary[i]^ary[j];
	}
}
