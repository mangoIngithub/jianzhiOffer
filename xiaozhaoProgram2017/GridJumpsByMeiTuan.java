package xiaozho2017;

import java.util.Scanner;
/**��Ŀ����һ��X*Y������С��Ҫ�ڴ������ϴ����Ͻǵ����½ǣ�ֻ���߸����ֻ�����һ������ߡ�
 *      �����һ���㷨������С���ж������߷�����������������int x,int y���뷵��С�ŵ��߷���Ŀ��
 * ˼·:���͵Ķ�̬�滮���⣬�����߷�ֻ�����һ������£����ÿ���������߷�ֻ���ϱߵ������߷�����������߷�֮��
 *     dp[i][j]=dp[i-1][]j+dp[i][j-1]�����ҵ�һ�к͵�һ�е�����������߷�Ϊ1.
 * @author lzw
 * @date 2017��12��18��
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
