import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	static int n, num1, num2, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str, postfix;

		for (int tc = 1; tc <= 10; tc++) {
			n = Integer.parseInt(br.readLine());
			str = br.readLine();
			postfix = infixToPostfix(str);
			System.out.printf("#%d %d\n", tc, postfixCalculator(postfix));
		}
	}

	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('+', 1);
		map.put('*', 2);
		map.put('-', 1);
		map.put('/', 2);
	}

	static String infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";

		for (char c : infix.toCharArray()) {
			if ('0' <= c && c <= '9')
				postfix += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			char popItem = stack.pop();
			postfix += popItem;
		}
		return postfix;
	}

	static int postfixCalculator(String postfix) {
		Stack<Integer> stack = new Stack<>();

		for (char c : postfix.toCharArray()) {
			if ('0' <= c && c <= '9')
				stack.push(c - '0');
			else {
				num1 = stack.pop();
				num2 = stack.pop();
				switch (c) {
				case ('+'):
					result = num2 + num1;
					break;
				case ('-'):
					result = num2 - num1;
					break;

				case ('*'):
					result = num2 * num1;
					break;

				case ('/'):
					result = num2 / num1;
					break;

				}
				stack.push(result);
			}
		}

		return stack.pop();
	}
}
