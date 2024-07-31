import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		int idx = 0;
		String input = br.readLine();

		while (idx < input.length()) {
			if (input.charAt(idx++) == '(') {
				if (input.charAt(idx) == ')') {
					idx++;
					ans += stack.size();
				} else {
					stack.push(1);
					ans += 1;
				}
			} else {
				stack.pop();
			}
		}
		System.out.println(ans);

	}
}