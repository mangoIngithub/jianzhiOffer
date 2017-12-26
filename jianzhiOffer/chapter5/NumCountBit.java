package jianzhioffer.chapter5;

import java.util.Scanner;

/**
 * 题目:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。 思路：统计1~n中X出现的次数
 * X出现在某位数上，注意：个位数时，1~10中X出现次数为1 十位数时，1~100中X出现次数为10 百位数时，1~1000中X出现次数为100
 * 需要记录高位所有数high,当前位数current,低位的所有数low,临时存除了高位以后的数tmp,当前第i位
 * 总结一下以上的算法，可以看到，
 * 当计算右数第  i  位包含的 X 的个数时： 取第  i  位左边（高位）的数字，乘以  10^i−1 ，得到基础值  a
 *  取第  i  位数字，计算修正值： 
 *  如果大于 X，则结果为  a+ 10^i−1 。
 *   如果小于 X，则结果为  a 
 *  。 如果等 X，则取第  i位右边（低位）数字，设为  b ，最后结果为  a+b+1 。 
 *    相应的代码非常简单，效率也非常高，时间复杂度只有  O( log 10 n) 。
 * 
 * @author Administrator
 * @date 2017年12月26日
 * @version version1.0
 */
public class NumCountBit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		System.out.println(NumberOfXBetween1AndN_Solution(n, x));

	}

	public static int NumberOfXBetween1AndN_Solution(int n, int x) {
		if (n < 0 || x < 1 || x > 9)
			return 0;
		int high, low, curr, tmp, i = 1;
		high = n;
		int total = 0;
		while (high != 0) {
			high = n / (int) Math.pow(10, i);// 获取第i位的高位
			tmp = n % (int) Math.pow(10, i);
			curr = tmp / (int) Math.pow(10, i - 1);// 获取第i位
			low = tmp % (int) Math.pow(10, i - 1);// 获取第i位的低位
			if (curr == x) {
				total += high * (int) Math.pow(10, i - 1) + low + 1;
			} else if (curr < x) {
				total += high * (int) Math.pow(10, i - 1);
			} else {
				total += (high + 1) * (int) Math.pow(10, i - 1);
			}
			i++;
		}
		return total;
	}

}
