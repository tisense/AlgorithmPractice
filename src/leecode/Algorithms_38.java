package leecode;


/**
 * leetcode 38 
 * 
 * 递归 + StringBuffer + 双指针
 * 性能最好是解法三，在解法一的基础上仅仅用StringBuffer代替了String 
 * @author renqi
 *
 */
public class Algorithms_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay3(5));
	}
	
	/**
	 * 解法一：递归 内存和耗时都一般
	 * 耗时 93ms
	 * 内存 39mb
	 * @param n
	 * @return
	 */
	public static String countAndSay(int n) {
		// 退出递归的条件
		if (n == 1) {
			return String.valueOf(n);
		}
		String sequence = countAndSay(n-1);
		int start = 0;
		int end = start;
		String r = "";
		char c = sequence.charAt(start);
		while (true) {
			if(end >= sequence.length()) { // 结束条件
				r = String.format("%s%d%c", r, end - start, c);
				break;
			}else if (c != sequence.charAt(end)) { // 下一个字符不相同
				r = String.format("%s%d%c", r, end - start, c);
				// 更新比较数据
				start = end;
				c = sequence.charAt(start);
			}else{ // 下一个字符相同
				++end;
			}
		}
		// System.out.println(String.format("%d %s %s", n, sequence, r));
		return r;
    }
	
	/**
	 * 在解法一上做了一些优化，与解法1没有本质区别 都是递归算法
	 * 是指去除了 String.value() 和 String.format()等方法 耗时23ms
	 * @param n
	 * @return
	 */
	public static String countAndSay2(int n) {
		// 退出递归的条件
		if (n == 1) {
			return "" + n;
		}
		String sequence = countAndSay(n-1);
		int start = 0;
		int end = start;
		String r = "";
		char c = sequence.charAt(start);
		while (true) {
			if(end >= sequence.length()) { // 结束条件
				r = r + (end - start) + c;
				break;
			}else if (c != sequence.charAt(end)) { // 下一个字符不相同
				r = r + (end - start) + c;
				// 更新比较数据
				start = end;
				c = sequence.charAt(start);
			}else{ // 下一个字符相同
				++end;
			}
		}
		return r;
    }
	
	public static String countAndSay3(int n) {
		// 退出递归的条件
		if (n == 1) {
			return "" + n;
		}
		String sequence = countAndSay(n-1);
		int start = 0;
		int end = start;
		StringBuffer r = new StringBuffer();
		char c = sequence.charAt(start);
		while (true) {
			if(end >= sequence.length()) { // 结束条件
				r.append(end - start).append(c);
				break;
			}else if (c != sequence.charAt(end)) { // 下一个字符不相同
				r.append(end - start).append(c);
				// 更新比较数据
				start = end;
				c = sequence.charAt(start);
			}else{ // 下一个字符相同
				++end;
			}
		}
		return r.toString();
    }

}
