import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;
	static List<Integer> list[];
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		int a, b;
		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];
		parent = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);

		
		for (int i = 2; i <= n; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		for (int i : list[idx]) {
			if (!visited[i]) {
				parent[i] = idx;
				dfs(i);
			}
		}
	}
}