package jianzhioffer.chapter3;
/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *     所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 解题思路：建立两个指针，index用于遍历，pEven用于指向第一个偶数的位置，一旦遍历到奇数，就相邻交换，终止条件是到pEven的位置，
 *         注意 pEven只初始化一次
 * @author lzw
 * @date 2017年12月15日
 * @version version1.0
 */
public class reOrderOddEven {
	
	
	
	public void reOrderArray(int [] array) {
        int index=0;
        int pEven=-1;
        int tempIndex,tempData;
        for(;index<array.length;index++){
            if(array[index]%2==0){
                if(pEven==-1){
                pEven=index;}
            }else{
                tempIndex=index;
                 
                while(pEven!=-1&&pEven<tempIndex){
                    swap(array,tempIndex,tempIndex-1);
                    tempIndex-=1;
                   
                }
                if(tempIndex==pEven){
                    pEven++;
                }
            }
           
        }
    }
    public void swap(int[] array,int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
}
