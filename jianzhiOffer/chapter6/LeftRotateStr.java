package jianzhioffer.chapter6;
/**题目：对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *     例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 * 思路：1.我的思路，时间复杂度O(N),空间复杂度O(N).
 *       首先构造一个长度为原字符串长度两倍的数组doubleC，把字符串重复两次初始化这个数组。
 *       然后左移n位，就相当于在这个doubleC中右移n位取值。
 *       注意,n=n%cSize.防止n大于cSize。
 *     2.书本，注意到左移n位操作，其实可以是先在字符串的前n位翻转，再把剩下的翻转。
 *       最后，把整个字符串翻转。这样就实现了左移操作
 * @author lzw
 * @date 2017年12月30日
 * @version version1.0
 */
public class LeftRotateStr {
	 /*
    public String LeftRotateString(String str,int n) {
        if(str==null){
            return null;
        }
        if(str.length()<=0||n<0){
            return "";
        }
        char[] cAry=str.toCharArray();
        int cSize=cAry.length;
        char[] doubleC=new char[cSize*2];
        for(int i=0;i<doubleC.length;i++){
            doubleC[i]=cAry[i%cSize];
            
        }
        char[] cResult=new char[cSize];
        for(int j=0;j<cSize;j++){
            cResult[j]=doubleC[j+n%cSize];
        }
        return String.valueOf(cResult);
    }
    */
     public String LeftRotateString(String str,int n) {
     if(str==null){
         return null;
     }
         if(str.length()==0||n<0){
             return "";
         }
         if(n==0){
             return str;
         }
         char[] cAry=str.toCharArray();
         int cSize=cAry.length;
       int firstStart=0;
       int firstEnd=(n-1)%cSize;
       int secStart=firstEnd+1;
       int secEnd=cSize-1;
       reverse(cAry,firstStart,firstEnd);
       reverse(cAry,secStart,secEnd);
       reverse(cAry,firstStart,secEnd);
         return String.valueOf(cAry);
       
     }
    public void reverse(char[] c,int start,int end){
        while(start<end){
            char tmp=c[start];
            c[start]=c[end];
            c[end]=tmp;
            start++;
            end--;
        }
    }
}
