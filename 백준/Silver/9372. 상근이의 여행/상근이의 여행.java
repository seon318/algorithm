import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b, cnt;
	static int[] parent;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			visited = new boolean[n + 1];
			list = new ArrayList[n + 1];
			parent = new int[n + 1];

			for (int i = 0; i < n + 1; i++) {
				list[i] = new ArrayList<>();
				parent[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			cnt = 0;
			for (int i = 1; i <= n; i++) {
				for (int v : list[i]) {
					if (findSet(i) != findSet(v)) {
						cnt++;
						union(findSet(i), findSet(v));
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int findSet(int x) {
		if (parent[x] != x) parent[x] = findSet(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		parent[y] = x;
	}
}