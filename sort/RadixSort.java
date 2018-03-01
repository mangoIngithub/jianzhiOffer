package cn.lzw.sort;

import java.util.ArrayList;
import java.util.List;

/**基数排序：
 * 			将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 			这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 * 
 * @author Lin
 *
 */
public class RadixSort {

	public static void sort(int[] ary) {
		//首先确定最大有多少位数
		int max=0;
		for (int i = 0; i < ary.length; i++) {
			if(ary[i]>max) {
				max=ary[i];
			}
		}
		//计算位数
		int times=0;
		while(max>0) {
			times++;
			max/=10;
		}
		
		//建立10个队列存储并初始化
		List<ArrayList> queueAll=new ArrayList<>();
		for(int i=0;i<10;i++) {
			ArrayList<Integer> queue=new ArrayList<>();
			queueAll.add(queue);
		}
		
		//收集元素
		for(int i=0;i<times;i++) {
			
			for(int j=0;j<ary.length;j++) {
				int x=(int) (ary[j]%Math.pow(10, i+1)/Math.pow(10, i));
				ArrayList<Integer> arrayList = queueAll.get(x);
				arrayList.add(ary[j]);
			}
			//索引计数器
			int index=0;
			//重新按队列内容排序
			for(int k=0;k<10;k++) {
				while(queueAll.get(k).size()>0) {
					ArrayList<Integer> arrayList = queueAll.get(k);
					Integer integer = arrayList.get(0);
					ary[index++]=integer;
					arrayList.remove(0);
				}
			}
		}
		
	}
	
//	public static void sort(int[] array) {
//		  //首先确定排序的趟数;    
//	       int max=array[0];    
//	       for(int i=1;i<array.length;i++){    
//	            if(array[i]>max){    
//	              max=array[i];    
//	            }    
//	       }    
//	       int time=0;    
//	       //判断位数;    
//	       while(max>0){    
//	          max/=10;    
//	           time++;    
//	       }    
//	   
//	        //建立10个队列;    
//	       List<ArrayList> queue=new ArrayList<ArrayList>();    
//	       for(int i=0;i<10;i++){    
//	              ArrayList<Integer>queue1=new ArrayList<Integer>();  
//	           queue.add(queue1);    
//	       }    
//	   
//	       //进行time次分配和收集;    
//	       for(int i=0;i<time;i++){    
//	           //分配数组元素;    
//	          for(int j=0;j<array.length;j++){    
//	               //得到数字的第time+1位数;  
//	                 int x=array[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10, i);  
//	                 ArrayList<Integer>queue2=queue.get(x);  
//	                 queue2.add(array[j]);  
//	                 queue.set(x, queue2);  
//	          }   
//	          int count=0;//元素计数器;    
//	          //收集队列元素;    
//	          for(int k=0;k<10;k++){  
//	               while(queue.get(k).size()>0){  
//	                   ArrayList<Integer>queue3=queue.get(k);  
//	                   array[count]=queue3.get(0);    
//	                   queue3.remove(0);  
//	                   count++;  
//	               }   
//	          }    
//	       }       
//	}
//	
	
	public static void swap(int[] ary,int i,int j) {
		ary[i]=ary[i]^ary[j];
		ary[j]=ary[i]^ary[j];
		ary[i]=ary[i]^ary[j];
	}
}
