package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leecode 20 有效的括号
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 * @author renqi
 *
 */
public class Algorithms_20 {

	public static void main(String[] args) {
		System.out.println(isValid("(])"));
	}

	public static boolean isValid(String s) {
		Stack<Character> factory = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		for (int i = 0; i < s.length(); i++) {
			Character currentChar = s.charAt(i);
			Character c = map.get(currentChar);
			if (c == null) {
				factory.push(currentChar);
			}else if (c != null && factory.isEmpty()) {
				return false;
			}else {
				Character top = factory.peek();
				if (top == c) {
					factory.pop();
				}else {
					factory.push(currentChar);
				}
			} 
		}
		return factory.isEmpty();
    }
}
