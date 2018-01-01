package jianzhioffer.chapter6;
/**题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：采用位运算，其中十进制加法相当于二进制异或运算，01、10为1，00、11为0。
 *      然后要判断进位。采用两者与之后左移可以得到进位。因为10、01、00都为0，只有11为1.
 * 
 * @author lzw
 * @date 2018年1月1日
 * @version version1.0
 */
public class BitAdd {
	  public int Add(int num1,int num2) {
	        int sum,carry;
	        do{
	            sum=num1^num2;
	            carry=(num1&num2)<<1;
	            num1=sum;
	            num2=carry;
	        }while(num2!=0);
	        return sum;
	    }
}
