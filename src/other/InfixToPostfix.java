package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/***
 * 1、中缀表达式 to 后缀表达式
 * 2、后缀表达式求值
 * @author renqi
 */
public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1+((2+3)*4)-5 ======》123+4*+5- ----> 16
		// 1 + 2*3 + (4 * 5 + 6) * 7 =======》123*+45*6+7*+  ---> 189
		Queue<Character> result = infixToPostfix("1+((2+3)*4)-5");
		System.out.println(calculate(result));
	}
	
	public static int calculate(Queue<Character> result) {
		Stack<String> stack = new Stack<String>();
		while (!result.isEmpty()) {
			Character c = result.poll();
			if (isDigital(c)) {
				stack.add(c.toString());
			}else if (isOperator(c)) {
				int a = Integer.valueOf(stack.pop().toString());
				int b = Integer.valueOf(stack.pop().toString());
				stack.add(String.valueOf(cal(a, b, c)));
			}
		}
		return Integer.valueOf(stack.pop().toString());
	}
	
	/**
	 * 计算
	 * 这里需要注意的是 a 、b 的出栈顺序与操作符/、 -的联系 
	 * @param a 第一个出栈的数 ---实际上是后进栈的
	 * @param b 第二个出栈的数 ---实际上是先进栈的
	 * @param operator
	 * @return
	 */
	public static int cal(int a,int b, char operator) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			// ⚠️顺序
			return b - a;
		case '*':
			return a * b;
		case '/':
			// ⚠️ 顺序和异常
			if(a == 0) return 0;
			return b / a;
		default:
			break;
		}
		return 0;
	}
	/**
	 * 
	 * 中缀表达式转后缀表达式
	 * +、-、*、/、()
	 * @param infixExp
	 * @return
	 */
	public static Queue<Character> infixToPostfix(String infixExp) {

		Stack<Character> stack = new Stack<Character>();
		Queue<Character> result = new LinkedList<Character>();
		
		for (int i = 0; i < infixExp.length(); i++) {
			Character c = infixExp.charAt(i);
			// 是数字的话就直接输出（入队列）
			if (isDigital(c)) {
				result.add(c);
			}else if (' ' == c) {
				continue;
			}else if ('(' == c) {
				// 遇到左括号直接入栈
				stack.add(c);
			}else if (isOperator(c)) {
				// 栈为空 直接入栈
//				if (stack.empty()) {
//					stack.add(c);
//				}else if (priority(c) > priority(stack.peek())) {
//					// 当前操作符优先级 > 栈顶操作符优先级  直接入栈
//					stack.add(c);
//				}else {
//					
//					result.add(stack.pop());
//				}
				while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
					// 当前操作符优先级 <= 栈顶操作符优先级 栈顶元素出栈
					result.add(stack.pop());
				}
				// 当前操作符优先级 > 栈顶操作符优先级  直接入栈
				stack.add(c);
			}else if(')' == c) {
				// 遇到右括号
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.add(stack.pop());
				}
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
			if (isDigital(stack.peek()) || isOperator(stack.peek())) {
				result.add(stack.pop());
			}else {
				stack.pop();
			}
		}
		return result;
	}
	
	//判断是符号
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

	/**
	 * 是否是数字
	 * @param c
	 * @return
	 */
	public static boolean isDigital(char c) {
		return c >= '0' && c <= '9';
	}
	/**
	 * 定义操作符的优先级
	 * @param c
	 * @return
	 */
	public static int priority(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;	
		default:
			// 应该抛出异常
			break;
		}
		return 0;
	}
}
