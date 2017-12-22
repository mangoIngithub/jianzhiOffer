package jianzhioffer.chapter5;
/**
 * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9��
 *      ����{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 *      ��������������0��
 * ˼·:1.ǳ�Ե�:����һ����¼����times��������������ԭ�����ֵ���������Ҫ�ҵ�ԭ��������ֵ������
 *       ��¼����times,һ�������ݾ�times[i]++������ж� times��������û�д��ԭ���鳤��һ��
 *       ʱ�临�Ӷ�O(N) �ռ临�Ӷ�ΪO(N)
 *     2.���ԭ�����г���һ�������������������һ������λ�����֡���������ҵ��������λ��
 *       Ȼ��������������г��ֵĴ���������һ�����У�û���򷵻�0  
 *       O(N)/O(NlogN)?
 * @author lzw
 * @date 2017��12��22��
 * @version version1.0
 */
public class MoreThanHalfNum {
	//˼·1
/*	   public int MoreThanHalfNum_Solution(int [] array) {
		     if(array.length<=0||array==null){
		         return 0;
		     }
		        int max=findMax(array);
		        int[] times=new int[max+1];
		        for(int i=0;i<array.length;i++){
		            times[array[i]]++;
		        }
		        for(int j=0;j<times.length;j++){
		            if(times[j]>array.length/2){
		                return j;
		            }
		        }
		        return 0;
		    }
		    public int findMax(int[] ary){
		        int max=Integer.MIN_VALUE;
		        for(int i=0;i<ary.length;i++){
		            if(ary[i]>max){
		                max=ary[i];
		                
		            }   
		        }
		        return max;
		    }
		    */
	
	
	//˼·2
	  public int MoreThanHalfNum_Solution(int [] array) {
	      if(array.length<=0||array==null){
	          return 0;
	      }
	        int middle=array.length/2;
	        int start=0;
	        int end=array.length-1;
	        int index=partition(array,start,end);
	        while(index!=middle){
	            if(index<middle){
	                index=partition(array,index+1,end);
	            }else{
	                index=partition(array,start,index-1);
	            }
	        }
	        int result=array[index];
	        int times=0;
	        for(int i=0;i<end+1;i++){
	            if(array[i]==result){
	                times++;
	            }
	        }
	        if(times>array.length/2){
	            return result;
	        } 
	        return 0;
	        
	    }
	    public int partition(int[] ary,int start,int end){
	        int pos=ary[start];
	        while(start<end){
	            while(start<end&&ary[end]>=pos)--end;
	            ary[start]=ary[end];
	            while(start<end&&ary[start]<=pos)++start;
	            ary[end]=ary[start];
	        }
	        ary[start]=pos;
	        return start;
	    }
}
