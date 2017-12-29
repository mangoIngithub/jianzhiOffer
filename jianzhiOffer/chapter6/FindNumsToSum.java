package jianzhioffer.chapter6;

import java.util.ArrayList;
/**题目：
   输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
   输出描述:
    对应每个测试案例，输出两个数，小的先输出。
思路：为了使乘积最小，当然两个数在满足条件的时候距离和的中心最远。因此可以想到用两个指标，p1一个指向最小，p2一个指向最大。
    p1+p2>sum时，应把p2--，这样得到的和才会小。p1+p2<sum时，应把p1++。这样从两边往里靠近 找到第一组满足即乘积会最小

 * 
 * @author lzw
 * @date 2017年12月29日
 * @version version1.0
 */
public class FindNumsToSum {
	 public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        if(array.length<=0||array[0]>=sum){
	            return list;
	        }
	        int start=0;
	        int end=array.length-1;
	        while(start<=end){
	            if(array[start]+array[end]>sum){
	                end--;
	            }else if(array[start]+array[end]==sum){
	                list.add(array[start]);
	                list.add(array[end]);
	                break;
	                
	            }else{
	                start++;
	            }
	        }
	        return list;
	    }
}
