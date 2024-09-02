import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] parent = new int[100001];
		boolean[] visited = new boolean[100001];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			
			if (x == k) break;
			
			if (2 * x <= 100000 && !visited[2 * x]) {
				visited[2 * x] = true;
				parent[2 * x] = x;
				queue.add(2 * x);
			}
			
			if (x + 1 <= 100000 && !visited[x + 1]) {
				visited[x + 1] = true;
				parent[x + 1] = x;
				queue.add(x + 1);
			}
			
			if (x > 0 && !visited[x - 1]) {
				visited[x - 1] = true;
				parent[x - 1] = x;
				queue.add(x - 1);
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int idx = k;
		while (idx != n) {
			stack.push(idx);
			idx = parent[idx];
		}
		stack.push(idx);
		
		sb.append(stack.size() - 1).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}