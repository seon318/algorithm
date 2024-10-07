import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int[][] cost;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i, i, 0);
		}
		System.out.println(ans);
	}
	
	static void dfs(int start, int now, int sum) {
		if (allVisited()) {
			if (cost[now][start] != 0)
				ans = Math.min(ans, sum + cost[now][0]);
			return;
		}
		
		for (int i = 1; i < n; i++) {
			if (cost[now][i] == 0 || visited[i]) continue;
			visited[i] = true;
			dfs(start, i, sum + cost[now][i]);
			visited[i] = false;
		}
	}
	
	static boolean allVisited() {
		for (int i = 0; i < n; i++) {
			if (!visited[i]) return false;
		}
		return true;
	}
}