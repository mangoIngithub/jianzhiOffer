package jianzhioffer.chapter3;
/**
 * ��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 *     ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò���
 * ����˼·����������ָ�룬index���ڱ�����pEven����ָ���һ��ż����λ�ã�һ�������������������ڽ�������ֹ�����ǵ�pEven��λ�ã�
 *         ע�� pEvenֻ��ʼ��һ��
 * @author lzw
 * @date 2017��12��15��
 * @version version1.0
 */
public class reOrderOddEven {
	
	
	
	public void reOrderArray(int [] array) {
        int index=0;
        int pEven=-1;
        int tempIndex,tempData;
        for(;index<array.length;index++){
            if(array[index]%2==0){
                if(pEven==-1){
                pEven=index;}
            }else{
                tempIndex=index;
                 
                while(pEven!=-1&&pEven<tempIndex){
                    swap(array,tempIndex,tempIndex-1);
                    tempIndex-=1;
                   
                }
                if(tempIndex==pEven){
                    pEven++;
                }
            }
           
        }
    }
    public void swap(int[] array,int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
}
