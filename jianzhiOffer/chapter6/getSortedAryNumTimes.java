package jianzhioffer.chapter6;
/**题目：统计一个数字在排序数组中出现的次数。
 * 思路:我的思路：因为是排序数组，可采用二分查找，找到K,然后往前往后遍历计算k出现的次数，
 *             但是这样的时间复杂度因为这样遍历还是O(N)
 *     书本的思路：改进二分查找。变成找第一次出现K的二分和找最后一次出现K的二分。
 *              每次找到k都判断前边一个或者后边一个是不是等于k,如果是就继续查找。       
 * 
 * @author lzw
 * @date 2017年12月27日
 * @version version1.0
 */
public class getSortedAryNumTimes {
	  /*
    public int GetNumberOfK(int [] array , int k) {
      if(array.length<=0){
          return 0;
      }
        int index=binarySearch(array,k);
        if(index==-1){
            return 0;
        }
        int times=1;
        int i=index;
        while(i>0){
            i--;
            if(array[i]==k){
                times++;
            }else{
                break;
            }
        }
        int j=index;
        while(j<array.length-1){
            j++;
            if(array[j]==k){
                times++;
            }else{
                break;
            }
               
        }
        return times;
    }
   
   public int binarySearch(int[] ary,int k){
        int start=0;
        int end=ary.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(ary[mid]>k){
                end=mid-1;
            }else if(ary[mid]==k){
                return mid;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    */
     public int GetNumberOfK(int [] array , int k) {
     if(array.length<=0){
         return 0;
     }
         int firstK=getFirstK(array,k);
         if(firstK==-1){
             return 0;
         }
         int lastK=getLastK(array,k);
         
         return lastK-firstK+1;
     }
    public int getFirstK(int[] ary,int k){
        int start=0;
        int end=ary.length-1;
           while(start<=end){
            int mid=(start+end)/2;
            if(ary[mid]>k){
                end=mid-1;
            }else if(ary[mid]==k){
                if(mid>0&&ary[mid-1]==k){
                    end=mid-1;
                }else{
                     return mid;
                }
               
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
        public int getLastK(int[] ary,int k){
        int start=0;
        int end=ary.length-1;
           while(start<=end){
            int mid=(start+end)/2;
            if(ary[mid]>k){
                end=mid-1;
            }else if(ary[mid]==k){
                if(mid<ary.length-1&&ary[mid+1]==k){
                    start=mid+1;
                }else{
                     return mid;
                }
               
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    
    
}
