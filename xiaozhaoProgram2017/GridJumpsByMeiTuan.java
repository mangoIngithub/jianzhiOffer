package xiaozho2017;

import java.util.Scanner;
/**题目：有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 *      请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 * 思路:典型的动态规划问题，由于走法只能向右或者向下，因此每个网格点的走法只由上边的网格走法和左边网格走法之和
 *     dp[i][j]=dp[i-1][]j+dp[i][j-1]，并且第一行和第一列的所有网格点走法为1.
 * @author lzw
 * @date 2017年12月18日
 * @version version1.0
 */
public class GridJumpsByMeiTuan {
	 public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        int x=sc.nextInt()+1;
	        int y=sc.nextInt()+1;
	        int[][] dp=new int[x][y];
	        for(int i=0;i<x;i++){
	            for(int j=0;j<y;j++){
	                if(i==0||j==0){
	                    dp[i][j]=1;
	                    continue;
	                }
	                dp[i][j]=dp[i-1][j]+dp[i][j-1];
	            }
	        }
	        System.out.println(dp[x-1][y-1]);
	    }
}
