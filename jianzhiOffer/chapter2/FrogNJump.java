package jianzhioffer.chapter2;
/**题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：每个台阶都有跳或者不跳的选择，除了最后的台阶必须跳。
 *     因此有2^(n-1)次。并且采用左移n-1来表示公式
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class FrogNJump {
    public int JumpFloorII(int target) {
        if(target<1){
            return 0;
        }
        return 1<<--target;
    }
}
