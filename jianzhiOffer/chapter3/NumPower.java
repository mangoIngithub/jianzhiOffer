package jianzhioffer.chapter3;
/**题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *      不考虑大数问题
 * 思路：注意指数是0、负数的情况。
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class NumPower {
    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }
        double result;
        if(exponent<0){
             result=getPower(base,exponent*-1);
            result=1/result;
        }else{
            result=getPower(base,exponent);
        }
        return result;
  }
    public static double getPower(double base,int exponent){
        double result=1.0;
        for(int i=0;i<exponent;i++){
            result*=base;
        }
        return result;
    }
}
