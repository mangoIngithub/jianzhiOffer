package jianzhioffer.chapter2;
/**题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路：判断是否为1，用与1操作。然后无符号右移1位。
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class NumbersOf1 {
    public int NumberOf1(int n) {
        int cnt=0;
         while(n!=0){
             if((n&1)==1){
                 cnt++;
                
             }
              n=n>>>1;
         }
           return cnt;
       
   }
}
