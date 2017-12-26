package jianzhioffer.chapter5;
/**题目：在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 *      中找到第一个只出现一次的字符,并返回它的位置
 * 思路：因为字母是用ASCII值表示，8位共256，因此可以构建一个256数组来存储字母，一旦有就加1
 *      再次遍历 第一个得到1的就返回位置索引
 * 
 * @author lzw
 * @date 2017年12月26日
 * @version version1.0
 */
public class FirstNotRepeating {
    public int FirstNotRepeatingChar(String str) {
        if(str.length()<1){
            return -1;
        }
        int[] ary=new int[256];
         for(int i=0;i<str.length();i++){
            ary[str.charAt(i)]++;
                 
          
            
        }
        for(int i=0;i<str.length();i++){
            if(ary[str.charAt(i)]==1){
                return i;
            }
            
        }
        return -1;
    }
}
