package jianzhioffer.chapter2;
/**题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *      请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：从右上角查询，若比目标大，就列减1往左移，若比目标小，就行加1往下移，直到遇到相等 返回true，否则返回false
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class FindNumIn2DArray {
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length<1||array[0].length<1){
            return false;
        }
   int j=array[0].length-1;
   for(int i=0;i<array.length;i++){
       for(;j>=0;j--){
           if(array[i][j]==target){
               return true;
           }else if(array[i][j]>target){
               continue;
           }else{
               break;
           }
       }
       
   }
   return false;
}
}
