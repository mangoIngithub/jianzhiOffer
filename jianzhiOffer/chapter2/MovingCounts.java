package jianzhioffer.chapter2;
/**题目：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 *      但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 *      因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *      请问该机器人能够达到多少个格子？
 * 思路：同样是回溯法，当满足约束条件步数阈值||没有访问过，在格子范围内，就继续左右上下递归。
 *      每成功1次计数加1，否则返回0     
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class MovingCounts {
    
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows<1||cols<1){
            return 0;
        }
        int steps=0;
        boolean[] visited=new boolean[rows*cols];
     
              steps=movingSteps(threshold,rows,cols,0,0,visited);
      return steps;
    }
    public int movingSteps(int threshold, int rows, int cols,int row,int col,boolean[] visited){
        if(threshold<bitCount(row)+bitCount(col)){
            return 0;
        }
        int steps=0;
        if(row>=0&&row<rows&&
          col>=0&&col<cols&&
          !visited[row*cols+col]){
            visited[row*cols+col]=true;
            steps+=1+movingSteps(threshold,rows,cols,row-1,col,visited)+movingSteps(threshold,rows,cols,row,col-1,visited)
                +movingSteps(threshold,rows,cols,row+1,col,visited)+movingSteps(threshold,rows,cols,row,col+1,visited);
          
        }
        return steps;
    }
    public int bitCount(int num){
        int sum=0;
       
        do{
          sum+=num%10;
          num=num/10;
          
        }while(num!=0);
        return sum;
    }
}
