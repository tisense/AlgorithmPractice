package leecode;

// 12 转罗马数字
//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

public class Algorithms_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rString = intToRoman2(20);
		System.out.println(rString);
	}
	
	public static String intToRoman(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
		String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		StringBuilder roman = new StringBuilder();
		int i = 0;
 		while (num >= 0 && i < values.length) {
			for (; i < values.length; i++) {
				if (values[i] > num) {
					continue;
				}else {
					roman.append(symbols[i]);
					num = num - values[i];
				}
			}
		}
		return roman.toString();
    }
	public static String intToRoman2(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
		String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < values.length && num >= 0; i++) {
			while (num >= values[i]) {
				num = num - values[i];
				roman.append(symbols[i]);
			}
		}
 		
		return roman.toString();
    }
}
