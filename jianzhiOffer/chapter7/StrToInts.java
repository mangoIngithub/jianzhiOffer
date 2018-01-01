package jianzhioffer.chapter6;
/**题目:将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
 *     数值为0或者字符串不是一个合法的数值则返回0
 * 思路:1.功能测试，正负数，因此要首先判断是否有+-号。采用isMinus作标志
 *       字符转数字采用高位乘10，累加低位与字符0的差值。
 *     2.边界测试，（最大正整数，最小负整数）。
 *       为了防止溢出。计算的整数采用long类型，并且每次累加完判断一下会不会超过边界值
 *       超过则返回0
 *     3.特殊测试，一开始就要判断空指针，多个空格，空输入。
 *     注意：因为0和非法输入都返回0，因此要用全局变量kValid表征是否有效。
 *     每次顺利访问到末尾则有效
 *     
 * @author lzw
 * @date 2018年1月1日
 * @version version1.0
 */
public class StrToInts {
	   public boolean kValue=false;
	    private int index=0;
	    public int StrToInt(String str) {
	        long num=0;
	        if(str!=null&&!str.matches("\\s+")&&str.length()>0){
	            char[] c=str.toCharArray();
	            boolean isMinus=false;
	            
	            if(c[index]=='-'){
	                index++;
	                 
	                isMinus=true;
	            }else if(c[index]=='+'){
	                index++;
	            }
	            
	            if(index<c.length){
	                num=StrToIntCore(c,isMinus);
	            }
	            
	            
	            
	        }
	           return (int)num;
	    }
	    public long StrToIntCore(char[] c,boolean isMinus){
	        long num=0L;
	        int flag=1;
	        if(isMinus){
	            flag=-1;
	        }
	        while(index<c.length){
	            if(c[index]>='0'&&c[index]<='9'){
	                num=num*10+flag*(c[index]-'0');
	                 if((isMinus&&num<0x80000000)||(!isMinus&&num>0x7FFFFFFF)){
	                    num=0L;
	                    break;
	                 }
	                 index++;
	            }else{
	                num=0L;
	               break;
	            }
	           
	        }
	        if(index==c.length){
	            kValue=true;
	        }
	       return num;
	    }
}
