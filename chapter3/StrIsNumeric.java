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
	            numeric=scanUnsignNum(str)||numeric;//ע������λ��˳��
	        }
	        if(index<str.length&&(str[index]=='e'||str[index]=='E')){
	            index++;//�ǵ�ÿ�ζ�Ҫ��һ ��һ������
	            numeric=numeric&&scanNum(str);//����Ҫ�������
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
	        while(str.length>index&&(str[index]>='0'&&str[index]<='9')){//ע��0-9�������������Ҫ������
	            index++;
	        }
	        return index>before;
	    }
 
}
