package jianzhioffer.chapter2;

import java.util.Scanner;
/**题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *  例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 思路：1.个人，采用额外o(n)空间的数组，以下标为标识，每读到一个数，它对应的下标值加1，
 *         一旦发现该下标的值为2，即为重复数字。
 *      2.遍历数组，按照排序的思想，首先，每个下标位置的数字都应该等于下标。如果不是，
 *        每个数字就应交换到它对应值的下标位置，如果该位置已经有与它相等的数
 *        就找到重复的，如果没有就交换位置。
 *        尽管有两次循环，但是每个数字最多只要交换2次，因此时间复杂度为O(N).
 * 
 * @author lzw
 * @date 2018年1月2日
 * @version version1.0
 */
public class DuplicateNumsInArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String[] strAry=str.split("\\s+");
		int[] numbers=new int[strAry.length];
		for(int i=0;i<strAry.length;i++) {
			numbers[i]=Integer.valueOf(strAry[i]);
		}
		int[] d=new int[1];
		boolean valid=duplicate(numbers,numbers.length,d);
		System.out.println(valid+"  "+d[0]);
	}
    /*
    public boolean duplicate(int numbers[],int length,int [] duplication) {
      if(numbers==null||length<1){
          return false;
      }
        int[] times=new int[length];
        boolean valid=false;
        for(int i=0;i<length;i++){
            times[numbers[i]]++;
            if(times[numbers[i]]==2){
               valid=true;
               duplication[0]=numbers[i];
               break;
            }
        }
        return valid;
    }
    */
    
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
    if(numbers==null||length<1){
          return false;
      }
        boolean valid=false;
       for(int i=0;i<length;i++){
           while(i!=numbers[i]){
               if(numbers[numbers[i]]==numbers[i]){
                   valid=true;
                   duplication[0]=numbers[i];
                   break;
               }else{
                   swap(numbers,i,numbers[i]);
               }
           }
           if(valid){
               break;
           }
           
       }
        return valid;
    
    
    }
    public static void swap(int[] ary,int i, int j){
        int tmp=ary[i];
        ary[i]=ary[j];
        ary[j]=tmp;
    }
}
