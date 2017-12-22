package jianzhioffer.chapter5;
/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的
 *      数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *      如果不存在则输出0。
 * 思路:1.浅显的:构建一个记录数组times，它的索引就是原数组的值。因此首先要找到原数组的最大值，创建
 *       记录数组times,一旦有数据就times[i]++，最后判断 times的数据有没有大过原数组长度一半
 *       时间复杂度O(N) 空间复杂度为O(N)
 *     2.如果原数组有超过一半的数，那数组的排序后一定在中位数出现。因此首先找到数组的中位数
 *       然后计算它在数组中出现的次数，超过一半则有，没有则返回0  
 *       O(N)/O(NlogN)?
 * @author lzw
 * @date 2017年12月22日
 * @version version1.0
 */
public class MoreThanHalfNum {
	//思路1
/*	   public int MoreThanHalfNum_Solution(int [] array) {
		     if(array.length<=0||array==null){
		         return 0;
		     }
		        int max=findMax(array);
		        int[] times=new int[max+1];
		        for(int i=0;i<array.length;i++){
		            times[array[i]]++;
		        }
		        for(int j=0;j<times.length;j++){
		            if(times[j]>array.length/2){
		                return j;
		            }
		        }
		        return 0;
		    }
		    public int findMax(int[] ary){
		        int max=Integer.MIN_VALUE;
		        for(int i=0;i<ary.length;i++){
		            if(ary[i]>max){
		                max=ary[i];
		                
		            }   
		        }
		        return max;
		    }
		    */
	
	
	//思路2
	  public int MoreThanHalfNum_Solution(int [] array) {
	      if(array.length<=0||array==null){
	          return 0;
	      }
	        int middle=array.length/2;
	        int start=0;
	        int end=array.length-1;
	        int index=partition(array,start,end);
	        while(index!=middle){
	            if(index<middle){
	                index=partition(array,index+1,end);
	            }else{
	                index=partition(array,start,index-1);
	            }
	        }
	        int result=array[index];
	        int times=0;
	        for(int i=0;i<end+1;i++){
	            if(array[i]==result){
	                times++;
	            }
	        }
	        if(times>array.length/2){
	            return result;
	        } 
	        return 0;
	        
	    }
	    public int partition(int[] ary,int start,int end){
	        int pos=ary[start];
	        while(start<end){
	            while(start<end&&ary[end]>=pos)--end;
	            ary[start]=ary[end];
	            while(start<end&&ary[start]<=pos)++start;
	            ary[end]=ary[start];
	        }
	        ary[start]=pos;
	        return start;
	    }
}
