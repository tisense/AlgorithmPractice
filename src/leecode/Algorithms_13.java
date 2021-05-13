package leecode;

import java.util.HashMap;

/**
 * 
 * 罗马数字转整数
 * @author renqi
 *
 */
public class Algorithms_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = romanToInt("IX");
		System.out.println(r);
	}

	public static int romanToInt(String s) {
		// int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
		// String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		HashMap<String, Integer> metaHashMap = new HashMap<String, Integer>();
		metaHashMap.put("M", 1000);
		metaHashMap.put("CM", 900);
		metaHashMap.put("D", 500);
		metaHashMap.put("CD", 400);
		metaHashMap.put("C", 100);
		metaHashMap.put("XC", 90);
		metaHashMap.put("L", 50);
		metaHashMap.put("XL", 40);
		metaHashMap.put("X", 10);
		metaHashMap.put("IX", 9);
		metaHashMap.put("V", 5);
		metaHashMap.put("IV", 4);
		metaHashMap.put("I", 1);
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i+1 < s.length() && metaHashMap.get(s.substring(i, i+2)) != null) {
				System.err.println(s.substring(i, i+2));
				result += metaHashMap.get(s.substring(i, i+2));
				// ⚠️这要 ++
				i +=1;
			}else {
				System.err.println(s.substring(i, i+1));
				result += metaHashMap.get(s.substring(i, i+1));
			}
		}
		return result;
    }
}
