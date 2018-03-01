package cn.lzw.sort;

import java.util.Scanner;

public class SortTest {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String[] inputs = sc.nextLine().split("\\s+");
	int[] ary=new int[inputs.length];
	for (int i = 0; i < ary.length; i++) {
		ary[i]=Integer.valueOf(inputs[i]);
	}
	System.out.println("排序前：");
	print(ary);
	 //调用排序方法
//	InsertSort.sort(ary);
//	ShellSort.sort(ary);
//	SelectSort.sort(ary);
//	HeapSort.sort(ary);
//	BubbleSort.sort(ary);
//	QuickSort.sort(ary);
//	MergeSort.sort(ary);
	RadixSort.sort(ary);
	
	System.out.println("排序后：");
	print(ary);
}
public  static  void print(int[] ary) {
	for(int i:ary) {
		System.out.print(i+" ");
	}
	System.out.println();
}
}
