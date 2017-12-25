package jianzhioffer.chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/**题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路：一、O(N)但会改变数组顺序。采用partition找索引的方法，因为partition返回索引时，左边会比此索引小，右边比它大，
 *         因此如果索引为K则找到了最小的K个数
 *      二、O（nlogK）算法，适合处理海量数据
 *         找一个容器存储K个数据，当容器满时，1.找到容器中的最大值 2.比较下个输入数据和容器的最大值，若数据小，则交换。
 *         java中采用PriorityQueue做容器，它是用堆实现的，查找和删除都是logn时间。
 *         默认为小根堆，得重载比较器，变成大根堆(o2.compareTo(o1))
 * @author lzw
 * @date 2017年12月25日
 * @version version1.0
 */
public class MinKNums {
	//思路1
/*	 public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
         ArrayList<Integer> list=new ArrayList<>();
        if(k>input.length||input.length<=0||k<=0){
            return list;
        }
        int start=0;
        int end=input.length-1;
        int index=partition(input,start,end);
        while(index!=k-1){
            if(index>k-1){
                index=partition(input,start,index-1);
            }else{
                index=partition(input,index+1,end);
            }
        }
       
        for(int i=0;i<=index;i++){
            list.add(input[i]);
        }
        return list;
    }
    public int partition(int[] ary,int start,int end){
        int pos=ary[start];
        while(start<end){
            while(start<end&&ary[end]>=pos)end--;
            ary[start]=ary[end];
            while(start<end&&ary[start]<=pos)start++;
            ary[end]=ary[start];
        }
        ary[start]=pos;
        return start;
    }*/
	
	  public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		  ArrayList<Integer> list=new ArrayList<>();
	        if(k>input.length||input.length<=0||k<=0){
	            return list;
	        }
	       PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				 
				return o2.compareTo(o1);
			}
		});
	        for(int i=0;i<input.length;i++) {
	        	if(queue.size()<k) {
	        		queue.add(input[i]);
	        	}else {
	        		if(input[i]<queue.peek()) {
	        			queue.poll();
	        			queue.add(input[i]);
	        		}
	        	}
	        }
	        for(Integer i:queue) {
	        	list.add(i);
	        }
	        return list;
	         
	    }
	
}
