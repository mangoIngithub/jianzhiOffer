package jianzhioffer.chapter2;
/**题目：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * 思路：递归
 *  数列 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368........
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class Fibonacci {
    public int Fibonacci1(int n) {
        if(n<1){
            return 0;
        }
           if(n==1||n==2){
               return 1;
           }
         int cur=1;
           int last=1;
         for(int i=2;i<n;i++){
             int tmp=cur;
             cur=cur+last;
             last=tmp;
         }
           return cur;
       }
}
