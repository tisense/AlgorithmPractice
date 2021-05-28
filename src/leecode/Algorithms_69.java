package leecode;

/**
 * leetcode 69 square root （x的平方根） [/skwer/]
 * @author renqi
 *
 */
public class Algorithms_69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2147483647
		//
		System.out.println(mySqrt(2147483647));
		//System.out.println(1/2);
	}

	/**
	 * 
	 * 需要注意溢出的问题：
	 * 1、边界溢出问题：middle*middle 或者 middle取上界时(我这里没有采用取上界的方法)
	   2、通过调试当 left == millde 时容死循环，
	      我采用的方法是将 (long)middle * middle < x 判断：只要middle*middle < x 就右移，
	      将最终的left 取到较大的值，最后通过一个if的判断看是否需要减一
	 * 
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		int left = 0;
		int right = x;
		int middle = 0;
		while (left < right) {
			middle = left + (right - left)/2;
			System.out.println(String.format("%d,%d,%d", left, middle, right));
			if ((long)middle * middle < x) {
				left = middle + 1;
			}else {
				right = middle;
			}
		}
		if ((long)left*left > x) {
			return --left;
		}
		return left;
    }
}
