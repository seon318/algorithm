import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		String input;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<t; tc++) {
			stack.removeAll(stack);
			input = br.readLine();
			for (int i=0; i<input.length(); i++) {
				if (input.charAt(i) == '(') stack.push(0);
				else {
					if (stack.size() == 0) {
						stack.push(0);
						break;
					}
					stack.pop();
				}
			}
			System.out.println(stack.size() == 0 ? "YES" : "NO");
		}

	}
}
