package leecode;

//8. 字符串转换整数 (atoi)
//请你来实现一个 atoi 函数，使其能将字符串转换成整数。
//
//首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
//
//1、如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
//2、假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
//3、该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
//注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
//
//在任何情况下，若函数不能进行有效的转换时，请返回 0 。
//
//提示：
//
//本题中的空白字符只包括空格字符 ' ' 。
//假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。

// 1、什么是有限状态机（deterministic finite automaton, DFA）
// 2、我的代码很臃肿
public class Algorithms_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// -42
		// "words and 987"
		// "-91283472332"
		// "  0000000000012345678"
		// "2147483648" == 2147483647
		// "  0000000000012345678"
		int result =  myAtoi("  0000000000012345678");
		System.out.println("输出结果：" + result);
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println("-91283472332");
		
//		System.out.println((int)'+'); // 43
//		System.out.println((int)','); // 44
//		System.out.println((int)'-'); // 45
//		System.out.println((int)'0'); // 48
//		System.out.println((int)'9'); // 57
		//System.out.println(Character.valueOf((char) 44)); // ,
		//System.out.println((int)'0' == 48); // true
//		System.out.println("abc".substring(1,3));
//		System.out.println('-' == '-');
		System.out.println();
	}

    public static int myAtoi(String s) {
    	s = s.trim();
    	if (s.length() < 1) {
			return 0;
		}
    	// 1、确定正负标志
    	int flag = 1;
    	if (s.charAt(0) == '-') {
    		flag = -1;
    		s = s.substring(1,s.length());
		}else if (s.charAt(0) == '+') {
			flag = 1;
			s = s.substring(1,s.length());
		}
    	System.out.println("flag=" + flag);
    	// 2、找到第一个不为0的位置start = index
    	int start = 0;
    	for (; start < s.length(); start++) {
    		int asgm = (int)s.charAt(start);
			if (asgm > 48 && asgm <= 57) {
				break;
			}
		}
    	// 排除start前面存在不是数字的情况
    	for (int i = 0; i < start; i++) {
			if (s.charAt(i) == '0') {
				continue;
			}else {
				return 0;
			}
		}
    	// 3、找到结束的数字位置end = index + 1
    	int end = start;
    	for (int i = start; i < s.length(); i++) {
    		int asgm = (int)s.charAt(i);
			if (asgm < 48 || asgm > 57) {
				break;
			}
			end += 1;
		}
    	System.out.println("start=" + start +",end=" + end);
    	String data = s.substring(start, end);
    	System.out.println("整数部分:"+data);
    	if (data.length() < 1 || data.charAt(0) == '0') {
			return 0;
		}
    	// 4、开始转换
    	int result = 0;
    	
    	for (int i = 0; i < data.length(); i++) {
			int pop = Integer.valueOf(String.valueOf(data.charAt(data.length() -1 - i)));
			System.out.println("pop:" + pop + ",i=" + i);
			if (pop * flag + result/(Math.pow(10, i) * 1.0f) > Integer.MAX_VALUE / Math.pow(10, i)) {
				System.out.println("MAX:" +pop * flag + result/10f+"," + Integer.MAX_VALUE / Math.pow(10, i));
				return Integer.MAX_VALUE;
			}else if(pop * flag + result/(Math.pow(10, i) * 1.0f) < Integer.MIN_VALUE / Math.pow(10, i)) {
				System.out.println("MIN");
				return Integer.MIN_VALUE;
			}
			result = result +  pop * (int) Math.pow(10, i)  * flag;
		}
    	return result;
    }
}
