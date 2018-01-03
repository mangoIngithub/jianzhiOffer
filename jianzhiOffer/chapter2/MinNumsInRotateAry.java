package jianzhioffer.chapter2;
/**题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，
 *      输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 *      NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：利用二分查找，两个指针，头尾。因为非递减，因此中间的数若比头大，则最小的数在右边，
 *      中间的数比尾小，则最小的数在左边，直到两个指针差值为1，最小的数在第二个指针。
 *      另外，当三者相同时，应该按照顺序查找。
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class MinNumsInRotateAry {
	  public int minNumberInRotateArray(int [] array) {
		     if(array==null||array.length<1){
		         return 0;
		     }
		      int start=0;
		      int end=array.length-1;
		      int mid=start;
		      while(array[start]>=array[end]){
		          if(end-start==1){
		              mid=end;
		              break;
		          }
		          mid=(start+end)/2;
		          if(array[mid]==array[start]&&array[mid]==array[end]){
		              return MinInOrder(array,start,end);
		          }
		          if(array[mid]>=array[start]){
		              start=mid;
		          }else if(array[mid]<=array[end]){
		              end=mid;
		          }
		          
		      }
		        return array[mid];
		    }
		    public int MinInOrder(int[] ary,int start,int end){
		        int result=ary[start];
		        for(int i=start;i<=end;i++){
		            if(result>ary[i]){
		                result=ary[i];
		                break;
		            }
		        }
		        return result;
		    }
}
