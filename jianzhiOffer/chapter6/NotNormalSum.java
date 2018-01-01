package jianzhioffer.chapter6;
/**题目：求1+2+3+...+n，要求不能使用乘除法、
        for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
        思路：因为被限制所以无法用乘法公式，循环，递归
        但是为了可以使用判断条件，采用短路与的特性，实现递归终止条件。
 * 
 * @author lzw
 * @date 2018年1月1日
 * @version version1.0
 */
public class NotNormalSum {
	   public int Sum_Solution(int n) {


	        int result = 0;
	        int a = 1;
	        boolean value = ((n!=0) && a == (result = Sum_Solution(n-1)));
	        result += n;
	        return result;
	    }
}
