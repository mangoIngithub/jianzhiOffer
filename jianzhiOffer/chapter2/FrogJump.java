package jianzhioffer.chapter2;
/**题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：经典动态规划
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class FrogJump {
    public int JumpFloor(int target) {
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
