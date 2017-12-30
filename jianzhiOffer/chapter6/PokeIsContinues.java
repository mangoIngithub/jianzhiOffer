package jianzhioffer.chapter6;
/**题目：从扑克牌中随机抽5张牌，判断是不是顺子。A为1，JQK为11、12、13.
 *     大小王当做0，可以作任意数字
 *思路:首先给数组排序；然后统计零出现的次数。计算相邻的差值和与零的个数，
 *    若小于等于则返回true，否则返回false。
 *    注意:差值可以利用一个变量记录上一个数的值，差值要减1 
 * @author lzw
 * @date 2017年12月30日
 * @version version1.0
 */
public class PokeIsContinues {
	   public boolean isContinuous(int [] numbers) {
		     if(numbers==null||numbers.length!=5){
		         return false;
		     }
		     selectSort(numbers);
		     int size0=0;
		     int dif=0;
		     int before=-1;
		        for(int i=0;i<numbers.length;i++){
		         if(numbers[i]==0){
		             ++size0;
		         }else{
		         if(before==-1){
		             before=numbers[i];
		         }else if(before==numbers[i]){
		             return false;
		         }else {
		             dif+=numbers[i]-before-1;
		             before=numbers[i];
		         }
		         
		         }
		     }
		        if(size0>=dif){
		            return true;
		        }else{
		            return false;
		        }
		     
		     
		    }
		    public void selectSort(int[] numbers){
		     for(int i=0;i<numbers.length-1;i++){
		         for(int j=i+1;j<numbers.length;j++){
		             if(numbers[i]>numbers[j]){
		                 swap(numbers,i,j);
		             }
		         }
		     }
		    }
		    public void swap(int[] ary,int i,int j){
		        ary[i]=ary[i]^ary[j];
		        ary[j]=ary[i]^ary[j];
		        ary[i]=ary[i]^ary[j];
		    }
}
