import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] towers = new int[n];
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}

		stack.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
				ans[stack.pop()] = i + 1;
			}
			stack.push(i);

		}

		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}

	}
}
