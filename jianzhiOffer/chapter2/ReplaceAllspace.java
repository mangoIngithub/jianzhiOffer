package jianzhioffer.chapter2;
/**题目：请实现一个函数，将一个字符串中的空格替换成“%20”。
 *      例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：1.我的，利用StringBuffer的insert函数，判断某个位置是空格，则插入字符数组{%20}，
 *       但要注意，循环条件的更改，不能是str.length()，因为长度一直在变，会出现异常。
 *      2.书本，遍历一次统计空格次数cnt，构建一个长度为cnt*2+原始数组长度的数组。然后两个后边指针
 *        往前移，一旦遇到空格，P2就添加（%20）,否则就直接复制。
 *      注意 ' '是空格，而'\0'是空字符
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class ReplaceAllspace {
	   /*
    public String replaceSpace(StringBuffer str) {
     
        char[] c={'%','2','0'};
       int length=str.length();
	 for(int i=0;i<length;i++){
         if(str.charAt(i)==' '){
        	 str.deleteCharAt(i);
             str.insert(i,c);
             i+=2;
             length+=2;
         }
     }
        return str.toString();
    }
    */
    public String replaceSpace(StringBuffer str) {
       String s=str.toString();
       char[] c=s.toCharArray();
        int cnt=0;
        for(int i=0;i<c.length;i++){
            if(c[i]==' '){
                cnt++;
            }
        }
        char[] ch=new char[cnt*2+c.length];
        int k=ch.length-1;
        for(int j=c.length-1;j>=0;j--){
            if(c[j]==' '){
                ch[k--]='0';
                ch[k--]='2';
                ch[k--]='%';
            }else{
                ch[k--]=c[j];
            }
        }
        return String.valueOf(ch);
    }
}
