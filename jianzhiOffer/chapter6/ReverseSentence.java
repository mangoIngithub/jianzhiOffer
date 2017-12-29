package jianzhioffer.chapter6;
/**题目：例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
 * 思路：1.我的 采用string.split以空格分割。然后交换首尾的字符串。注意，要防止多个字符串输入，因此要用str.matches("\\s+")若true,则返回str
 *     2.书本。翻转两次。第一次把所有都翻转。第二次以空格为分隔符判断条件。每个单词再翻转一次。这样就可以得到结果。
 *      注意第二次时的终止条件start<cAry.length
 *     
 * 
 * @author lzw
 * @date 2017年12月29日
 * @version version1.0
 */
public class ReverseSentence {
	   /*
    public String ReverseSentence(String str) {
        if(str==null){
            return null;
        }
         String s="";
        if(str.length()<=0){
          return s;
      }
       
        
        if(str.matches("\\s+")){
            return str;
        }
       String[] strAry=str.split("\\s+");
         
       int start=0;
        int end=strAry.length-1;
        while(start<end){
            swap(strAry,start,end);
            start++;
            end--;
        }
     
        for(int i=0;i<strAry.length-1;i++){
            s+=strAry[i]+" ";
        }
        s+=strAry[strAry.length-1];
        return s;
    }
    public void swap(String[] ary,int i,int j){
        String temp=ary[i];
        ary[i]=ary[j];
        ary[j]=temp;
    }
    */
    public String ReverseSentence(String str) {
         
        if(str.length()<=0){
            return "";
        }
        if(str==null){
            return null;
        }
        char[] cAry=str.toCharArray();
        reverse(cAry,0,cAry.length-1);
        int index=0;
        int start=0;
        while(start<cAry.length){
            if(cAry[start]==' '){
                start++;
                index++;
            }else 
            if(index==cAry.length||cAry[index]==' '){
                reverse(cAry,start,index-1);
                start=++index;
            }else{
                index++;
            }
        }
        return new String(cAry);
        
        
    }
    
    public void reverse(char[] c,int start,int end){
        while(start<end){
            char tmp=c[start];
            c[start]=c[end];
            c[end]=tmp;
            start++;
            end--;
        }
    }
}
