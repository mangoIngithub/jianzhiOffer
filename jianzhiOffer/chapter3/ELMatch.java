package jianzhioffer.chapter3;
/**题目：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 *      而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 *      例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *思路：首先返回true条件是字符串strIndex和模板数组pIndex的索引都走到尽头，如果模板到尽头而字符串没有返回false
 *     判断的时候，先判断第二个字符是不是'*'，如果是的话 判断是否相等 是的话字符串有可能strIndex+1,pIndex+2，
 *     或者strIndex+1,pIndex或者strIndex,pIndex+2。不相等strIndex,pIndex+2
 *     正常相等时字符串与模板值相等，或者模板值=='.'
 *     注意每次比较前判断索引会不会越界      
 * 
 * @author lzw
 * @date 2018年1月3日
 * @version version1.0
 */
public class ELMatch {
	public boolean match(char[] str, char[] pattern)
    {
    if(str==null||pattern==null){
    return false;
    }
    return matchCore(str,pattern,0,0);
    }
    public boolean matchCore(char[] str,char[] pattern,int strIndex,int pIndex){
    if(strIndex==str.length&&pIndex==pattern.length){
        return true;
    }
        if(strIndex!=str.length&&pIndex==pattern.length){
            return false;
        }
        
        if(pIndex+1!=pattern.length&&pattern[pIndex+1]=='*'){
            if(strIndex!=str.length&&(str[strIndex]==pattern[pIndex]||pattern[pIndex]=='.')){
                return matchCore(str,pattern,strIndex+1,pIndex+2)||
                      matchCore(str,pattern,strIndex+1,pIndex)||
                    matchCore(str,pattern,strIndex,pIndex+2);
            }else{
                return  matchCore(str,pattern,strIndex,pIndex+2);
            }
        }
        
        if(strIndex!=str.length&&(str[strIndex]==pattern[pIndex]||pattern[pIndex]=='.')){
            return   matchCore(str,pattern,strIndex+1,pIndex+1);
        }
       return false;
    }
}
