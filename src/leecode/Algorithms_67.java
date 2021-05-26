package leecode;

/**
 * leetcode 67 add binary 二进制和
 * @author renqi
 *
 */
public class Algorithms_67 {

	

	public static void main(String[] args) {
			//System.out.println(Integer.valueOf('0'));
			//System.out.println(Integer.valueOf('1'));
			//110010 10111
			//
			System.out.println(addBinary("110010", "10111"));
	}
	
	public static String addBinary02(String a, String b) {
		StringBuffer buffer = new StringBuffer();
		
		return buffer.toString();
	}

	/**
	 * 方式：位运算
	 * & 与运算，  两个位都为1时，结果才为1
	 * ^ 异或运算，两个位相同为0，相异为1
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
		int pointA = a.length() - 1;
		int pointB = b.length() - 1;
		int bitA = 0;
		int bitB = 0;
		int c = 0; // 进位值
		StringBuffer buffer = new StringBuffer();
		while (pointA >=0 && pointB >= 0) {
			bitA = (a.charAt(pointA) == '0')? 0:1;
			bitB = (b.charAt(pointB) == '0')? 0:1;
			buffer.insert(0, (bitA^bitB^c));
			// 1、同为1的时候进位是1，补位无所谓
			// 2、a和b有一个为1，补位为1时
			// 注意位运算的优先级
			c = ((bitA^bitB) == 0)?(bitA&bitB):( (bitA^bitB) &c);
			pointA--;pointB--;
		}
		System.out.println("bu:"+c);
		if (pointA < 0 && pointB < 0 && c != 0) {
			buffer.insert(0, "1");
		}else if (pointB >= 0) {
			while (pointB >= 0) {
				bitB = (b.charAt(pointB) == '0')? 0:1;
				buffer.insert(0, bitB^c);
				c = bitB&c;
				pointB --;
			}
			if (c != 0) {
				buffer.insert(0, c);
			}
		}else if (pointA >= 0){
			while (pointA >= 0) {
				bitA = a.charAt(pointA) == '0'? 0:1;
				buffer.insert(0, bitA^c);
				c = bitA&c;
				pointA --;
			}
			if (c != 0) {
				buffer.insert(0, c);
			}
		}
		return buffer.toString();
    }
}
