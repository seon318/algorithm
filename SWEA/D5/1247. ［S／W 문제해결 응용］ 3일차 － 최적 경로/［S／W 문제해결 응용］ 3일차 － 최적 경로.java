import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n, d, ans;
	static int[][] loc, dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			loc = new int[(n + 2) * 2][2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n + 2; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dist = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if (i == j) continue;
					d = Math.abs(loc[i][0] - loc[j][0]) + Math.abs(loc[i][1] - loc[j][1]);
					dist[i][j] = d;
					dist[j][i] = d;
				}
			}
						
			ans = Integer.MAX_VALUE;
			visited = new boolean[n + 2];
			visited[0] = true;
			perm(1, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt, int idx, int distance) {
		if (cnt == n + 1) {
			distance += dist[idx][1];
			ans = Math.min(distance, ans);
		}
		
		for (int i = 2; i < n + 2; i++) {
			if (i == idx || visited[i]) continue;
			visited[i] = true;
			perm(cnt + 1, i, distance + dist[idx][i]);
			visited[i] = false;
		}
	}
}