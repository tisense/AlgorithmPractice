package leecode;



//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//示例 1:
//
//输入: 123
//输出: 321
// 示例 2:
//
//输入: -123
//输出: -321
//示例 3:
//
//输入: 120
//输出: 21
//注意:
//
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reverse-integer
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//2021年01月04日
//如果 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 导致溢出，那么一定有 \text{rev} \geq \frac{INTMAX}{10}rev≥ 
//10
//INTMAX
//​	
// 。
//如果 \text{rev} > \frac{INTMAX}{10}rev> 
//10
//INTMAX
//​	
// ，那么 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
//如果 \text{rev} == \frac{INTMAX}{10}rev== 
//10
//INTMAX
//​	
// ，那么只要 \text{pop} > 7pop>7，temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。
public class Algorithms_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(120));
		// 最小整数 2^32 -2147483648
		Long vLong = (long) (2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2);
		System.out.println(vLong);
		
		// System.out.println(2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2 + 1);
		// 最大整数 2^32 - 1
		// System.out.println(2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2*2 *2*2*2 - 1);
		// int minValue = Integer.MIN_VALUE;
		// int maxValue = Integer.MAX_VALUE;
	}

	// 利用数学方法得到每一位的值 然后反转
	// 在反转的过程中检查溢出
	
	/**
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int rev = 0;
		int pop = 0;
		while (x != 0) {
			pop = x % 10;
			x = x / 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && pop > Integer.MAX_VALUE % 10)) {
				return 0;
			}else if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE && pop < Integer.MIN_VALUE % 10)) {
				return 0;
			} 
			rev = rev * 10 + pop;
		}
		return rev;
    }
}
