package jianzhioffer;

public class StrIsNumeric {
	 int index=0;
	    public boolean isNumeric(char[] str) {
	        if(str==null){
	            return false;
	        }
	        boolean numeric=scanNum(str);
	        if(index<str.length&&str[index]=='.'){
	            index++;
	            numeric=scanUnsignNum(str)||numeric;//注意两者位置顺序
	        }
	        if(index<str.length&&(str[index]=='e'||str[index]=='E')){
	            index++;//记得每次都要加一 有一步操作
	            numeric=numeric&&scanNum(str);//这里要检查正负
	        }
	        return numeric&&str.length==index;
	    }
	    public boolean scanNum(char[] str){
	        if(str.length>index&&(str[index]=='-'||str[index]=='+')){
	            index++;
	            return scanUnsignNum(str);
	        }
	        return scanUnsignNum(str);
	    }
	    public boolean scanUnsignNum(char[] str){
	        int before=index;
	        while(str.length>index&&(str[index]>='0'&&str[index]<='9')){//注意0-9是与操作，并且要括起来
	            index++;
	        }
	        return index>before;
	    }
 
}
