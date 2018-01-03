package jianzhioffer.chapter2;
/**题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *      路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *      如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *      例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *      因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 思路：回溯算法，约束条件是当前的位置在格子范围内，且符合理论要的字符，并且没有访问过，就可以继续上下左右的走。
 *      如果找不到就回溯，回溯的时候要把当前的字符的长度减1并且访问标志置为false.
 *      要建立一个一样大的visited数组。
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class MatrixHasPath {
	   public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    {
	     if(matrix==null||rows<1||cols<1||str==null){
	         return false;
	     }
	     boolean[] visited=new boolean[rows*cols];
	        
	        int pathLength=0;
	        for(int row=0;row<rows;row++){
	         for(int col=0;col<cols;col++){
	             if(hasCore(matrix,rows,cols, str,row,col,pathLength,visited)){
	                 return true;
	         }
	     }
	     
	    }
	        return false;}
	    public boolean hasCore(char[] matrix, int rows, int cols, char[] str,int row,int col,int pathLength,boolean[] visited){
	        
	        if(pathLength==str.length){
	            return true;
	        }
	        boolean hasPath=false;
	        if(row>=0&&row<rows
	           &&col>=0&&col<cols
	           &&matrix[row*cols+col]==str[pathLength]
	          &&!visited[row*cols+col]){
	            pathLength++;
	            visited[row*cols+col]=true;
	            hasPath=hasCore(matrix,rows,cols, str,row,col-1,pathLength,visited)||
	                hasCore(matrix,rows,cols, str,row-1,col,pathLength,visited)||
	                hasCore(matrix,rows,cols, str,row,col+1,pathLength,visited)|| 
	                    hasCore(matrix,rows,cols, str,row+1,col,pathLength,visited)                   
	                    ;
	            if(!hasPath){
	                pathLength--;
	                visited[row*cols+col]=false;
	            }
	            
	        }
	        return hasPath;
	        
	    }
}
