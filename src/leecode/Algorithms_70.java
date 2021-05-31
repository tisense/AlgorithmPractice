package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Climbing staris
 * 
 * 递归
 * 时间复杂度是 O(2^n) 
 * 空间复杂度是 O(n)
 * 
 * @author renqi
 *
 */
public class Algorithms_70 {

	public static int mCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs3(4));
//		System.out.println(mCount);
//		int a = 0;
//		test(a);
//		test(a);
//		System.out.println(a);
	}
	
	public static int climbStairs3(int n) {
		int beforeOneStair = 0;
		int beforeTwoStair = 0;
		int temp = 0;
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
                beforeOneStair = 1;
                beforeTwoStair = 0;
			}else if( i == 2) {
				beforeOneStair = 1;
				beforeTwoStair = 1;
			}else {
				temp = beforeTwoStair;
				beforeTwoStair = beforeOneStair;
				beforeOneStair = temp + beforeOneStair;
			}
		}
		return beforeTwoStair + beforeOneStair;
    }

	public static int climbStairs2(int n) {
		return climb(n);
    }
	public static int climb(int n) {
		if (n == 1) {
			return 1;
		}else if (n == 2) {
			return 2;
		}
		return climb(n - 1) + climb(n - 2);
	}
	
	/**
	 * 超出时间限制 😭
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		return climbStep(n, 0, 1) + climbStep(n, 0, 2);
    }
	
	/**
	 * @param n
	 * @param step
	 * @param nextStep
	 * @return
	 */
	public static int climbStep(int n, int step, int nextStep) {
		//System.out.println(String.format("n=%d,step=%d,nextStep=%d,count=%d", n, step, nextStep, count));
		mCount = mCount + 1;
		if (step + nextStep > n) {
			return 0;
		}else if (step + nextStep == n) {
			return 1;
		}else {
			return climbStep(n, step + nextStep, 1) + climbStep(n, step + nextStep, 2);
		}
		
	}

}
