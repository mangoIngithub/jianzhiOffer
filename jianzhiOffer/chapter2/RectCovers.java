package jianzhioffer.chapter2;
/**题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *      请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：依旧是斐波那契，经典动态规划     
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class RectCovers {
    public int RectCover(int target) {
    if(target<1){
        return 0;
    }
     int last=1;
     int cur=2;
      if(target==1){
          return last;
      }
        if(target==2){
            return cur;
        }
        for(int i=2;i<target;i++){
            int tmp=cur;
            cur+=last;
            last=tmp;
        }
        return cur;
    }
}
