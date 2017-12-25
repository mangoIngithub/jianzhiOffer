package jianzhioffer.chapter5;
/**题目：如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 *      连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * 思路:连续序列中要是累加和不小于0，说明对连续子序列和有帮助，可以继续累加。一旦子序列和为负数，则舍弃前边 重新累加。
 *     设定一个变量记录最大和
 * 
 * @author lzw
 * @date 2017年12月25日
 * @version version1.0
 */
public class GreatestSumOfSubArray {
	 public int FindGreatestSumOfSubArray(int[] array) {
	       int maxSum=array[0];
	       int currentSum=array[0];
	        for(int i=1;i<array.length;i++){
	            if(currentSum>0){
	                currentSum+=array[i];
	            }else{
	                currentSum=array[i];
	            }
	            if(currentSum>maxSum){
	                maxSum=currentSum;
	            }
	        }
	        return maxSum;
	    }
}
