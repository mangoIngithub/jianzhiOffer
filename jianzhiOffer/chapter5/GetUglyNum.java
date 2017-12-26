package jianzhioffer.chapter5;
/**题目：把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 
 *      习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 * 思路：以因子2、3、5来构造每一个丑数，构建一个数组用来按顺序存储丑数。构建M2,M3,M5的指针，
 *     意思是指向的丑数再乘以2或3或5就会比数组中当前最大的丑数大的位置。
 *      然后每次选择他们中最小的乘积作为下一个丑数。然后移动三个指针
 * @author lzw
 * @date 2017年12月26日
 * @version version1.0
 */
public class GetUglyNum {
	   public int GetUglyNumber_Solution(int index) {
	        if(index<1){
	            return 0;
	        }
	        int[] uglyNums=new int[index];
	        int M2=0,M3=0,M5=0;
	        uglyNums[0]=1;
	        int uglyIndex=1;
	        while(uglyIndex<index){
	            int min=Min(uglyNums,M2,M3,M5);
	            uglyNums[uglyIndex]=min;
	            while(uglyNums[M2]*2<=uglyNums[uglyIndex])
	                M2++;
	            while(uglyNums[M3]*3<=uglyNums[uglyIndex])
	                M3++;
	            while(uglyNums[M5]*5<=uglyNums[uglyIndex])
	                M5++;
	            uglyIndex++;
	            
	        }
	        int result=uglyNums[uglyIndex-1];
	        return result;
	        
	        
	         
	    }
	    public int Min(int[] uglyNums,int M2,int M3,int M5){
	        int min=uglyNums[M2]*2<uglyNums[M3]*3?uglyNums[M2]*2:uglyNums[M3]*3;
	        return min<uglyNums[M5]*5?min:uglyNums[M5]*5;
	    }
}
