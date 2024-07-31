import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int k = Integer.parseInt(br.readLine());
		int x;
		for (int i=0; i<k; i++) {
			x = Integer.parseInt(br.readLine());
			if (x == 0) stack.pop();
			else stack.push(x);
		}
		int sum = 0;
		while (stack.size() > 0) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
