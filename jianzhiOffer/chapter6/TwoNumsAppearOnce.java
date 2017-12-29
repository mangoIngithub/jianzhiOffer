package jianzhioffer.chapter6;
/**题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：1.简单做法，时间O(N)，但空间也O(N).采用哈希表记录每个数字出现的次数，最后只有一次的就是要找的
 *     2.要求时间复杂度O(N)，空间复杂度O(1) 采用异或操作，因为两个相同的数字异或为0，因此把所有数字异或可以得到只出现一次的数字。
 *      但是因为有两个 因此采用分组，所有数字异或的结果，判断它的1最低位，以此位置是否为1来分组，判断是否为1可采用右移 再与1的操作。
 * 
 * @author lzw
 * @date 2017年12月29日
 * @version version1.0
 */
public class TwoNumsAppearOnce {
	  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	        if(array.length<=0){
	            return;
	        }
	        int temp=0;
	        for(int i=0;i<array.length;i++){
	           temp=temp^array[i];
	        }
	        if(temp==0){
	            return;
	        }
	        int index=0;
	        while((temp&1)==0){
	            temp=temp>>1;
	            index++;
	        }
	        int n1=0;
	        int n2=0;
	        for(int i=0;i<array.length;i++){
	            if(isBit(array[i],index)){
	                n1=n1^array[i];
	            }else{
	                n2=n2^array[i];
	            }
	        }
	        num1[0]=n1;
	        num2[0]=n2;
	        
	        
	        
	        
	    }
	    public boolean isBit(int data,int index){
	        for(int i=0;i<index;i++){
	            data=data>>1;
	        }
	        return (data&1)==0;
	    }
	    
	   /*
	    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	        if(array.length<=0){
	            return;
	        }
	        HashMap<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<array.length;i++){
	            if(map.containsKey(array[i])){
	                map.put(array[i],map.get(array[i])+1);
	            }else{
	                map.put(array[i],1);
	            }
	        }
	        boolean first=true;
	        for(Entry<Integer,Integer> entry:map.entrySet()){
	            if(entry.getValue()==1){
	                if(first){
	                    num1[0]=entry.getKey();
	                    first=false;
	                }else{
	                    num2[0]=entry.getKey();
	                }
	            }
	        }
	    }
	    */
}
