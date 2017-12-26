package jianzhioffer.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 *      则打印出这三个数字能排成的最小数字为321323。
 * 思路：把数组元素存储在容器中，容器按照组合最小的排序方式排序。
 *      组合最小的排序规则如下：若n>m，则nm>mn。若m>n，则mn>nm。而nm,mn位数相同因此先组合起来再排序，
 *      而组合起来为了避免溢出，是大数问题，采用字符串。String str1=i1+""+i2;
 *      具体容器采用ArrayList,排序采用重写Comparator
 * 
 * @author lzw
 * @date 2017年12月26日
 * @version version1.0
 */
public class ArrayCombineMin {
	   public String PrintMinNumber(int [] numbers) {
	       if(numbers==null||numbers.length<0){
	           return null;
	       }
	        ArrayList<Integer> list=new ArrayList<>();
	        for(Integer i:numbers){
	            list.add(i);
	        }
	        Collections.sort(list,new Comparator<Integer>(){
	            @Override
	            public int compare(Integer i1,Integer i2){
	                String str1=i1+""+i2;
	                String str2=i2+""+i1;
	                return str1.compareTo(str2);
	            }
	        });
	        String s="";
	        for(Integer i:list){
	            s+=i;
	        }
	        return s;
	    }
}
