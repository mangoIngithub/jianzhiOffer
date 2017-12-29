package jianzhioffer.chapter6;

import java.util.ArrayList;
/**题目:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路:我的，采用求和公式，用一个基准变量num，和一个增加变量b，判断求和公式(num*2+b)*(b+1)==sum*2，如果小于就b++，
 *          如果大于就num++,b重置为1.终止条件num<=sum/2
 *      书本:采用small和big变量，curSum=samll+big，如果小于sum，则big++，再curSum+=sum，若相等，则存起来，big再++，
 *      或者大于的话就curSum减去small，small++.
 * 
 * @author lzw
 * @date 2017年12月29日
 * @version version1.0
 */
public class ContinuousSequenceSum {
	  /*
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
     ArrayList<ArrayList<Integer>> allList=new ArrayList<ArrayList<Integer>>();
        if(sum<3){
            return allList;
        }
        int num=1;
        while(num<=sum/2){
            int b=1;
            while(true){
                if((num*2+b)*(b+1)<sum*2){
                    b++;
                }else if((num*2+b)*(b+1)==sum*2){
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    for(int i=0;i<=b;i++){
                        list.add(num+i);
                    }
                    allList.add(list);
                    b++;
                }else{
                    break;
                }
            }
            num++;
        }
        return allList;
    }
    */
     public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
          ArrayList<ArrayList<Integer>> allList=new ArrayList<ArrayList<Integer>>();
        if(sum<3){
            return allList;
        }
         int small=1;
         int big=2;
         int curSum=small+big;
         while(small<(sum+1)/2){
             if(curSum<sum){
                 big++;
                 curSum+=big;
             }else if(curSum==sum){
                 ArrayList<Integer> list=new ArrayList<Integer>();
                 for(int i=0;i<=(big-small);i++){
                     list.add(small+i);
                 }
                 allList.add(list);
                 big++;
                 curSum+=big;
             }else{
                 curSum-=small;
                 small++;
             }
         }
         return allList;
     }
}
