package leecode;

import java.util.Arrays;

/**
 * leetcode 66 one plus
 * 
 * @author renqi
 *
 */
public class Algorithms_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = new int[] {9, 9, 0,9};
		int[] r = plusOne(res);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i]);
		}
	}
	
	/**
	 * 1、满9进1的邻届条件
	 * 2、倒序循环
	 * 3、这里面存在机巧 倒序的时候 不满9 直接加1 就是结果
	 * 
	 * @param digits
	 * @return
	 */
    public static int[] plusOne(int[] digits) {
 
    	// case1: 没有进到最后一位，先 else代码块 后if代码块，eg: 1099
    	// case2: 如果第一个要加的数字不是9 直接执行if并返回 eg: 123
    	// case3: 最后1位需要进位，数组长度会加1 eg: 999
    	for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i] = digits[i] + 1;
				return digits; // 一定要返回 这里很关键
			}else {
				// 遇到9
				digits[i] = 0;		
			}
		}
    	// 如果全部是9则会走到这里
    	// 数组中所有的数字都是9的时候
    	int[] temp = new int[digits.length + 1];
    	temp[0] = 1;
    	return temp;
    }

}
