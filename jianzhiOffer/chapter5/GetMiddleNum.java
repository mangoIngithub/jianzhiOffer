package jianzhioffer.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 思路：数据是一位一位输入的。采用一个最大堆和最小堆存储。最大堆存储的是降序中的最大值，最小堆存储的是升序后的最大值。
 *      为了保证最大堆最小堆数值相差一个，总数奇数就存储在最小堆，总数偶数就存储在最大堆。
 *      存储的时候，为了保证最小堆的数大于最大堆的数。存储最小堆时，先把数存进最大堆，再取出最大堆的最大值放到最小堆。存最大堆时类似 
 * @author lzw
 * @date 2017年12月25日
 * @version version1.0
 */
public class GetMiddleNum {
	 PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>(){
	        @Override
	        public int compare(Integer o1,Integer o2){
	            return o2.compareTo(o1);
	        }
	    });
	    int count=0;
	    public void Insert(Integer num) {
	        if((count&1)==0){
	          
	            maxHeap.offer(num);
	            int max=maxHeap.poll();
	            minHeap.offer(max);
	           
	            
	           
	        }else{
	           minHeap.offer(num);
	            int min=minHeap.poll();
	            maxHeap.offer(min);
	              
	        }
	     count++;
	    }

	    public Double GetMedian() {
	     if((count&1)==0){
	         return Double.valueOf((maxHeap.peek()+minHeap.peek()))/2;
	     }else{
	         return Double.valueOf(minHeap.peek());
	     }
	    }
}
