import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int h;
		int n = Integer.parseInt(br.readLine());
		long sum = 0;

		for (int i = 0; i < n; i++) {
			h = Integer.parseInt(br.readLine());
			while (!stack.isEmpty()) {
				if (stack.peek() <= h)
					stack.pop();
				else
					break;
			}
			sum += stack.size();
			stack.push(h);
		}
		System.out.println(sum);
	}
}