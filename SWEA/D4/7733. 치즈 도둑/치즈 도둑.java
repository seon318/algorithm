import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, max, sum, ans;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			cheese = new int[n][n];
			max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, cheese[i][j]);
				}
			}
			
			ans = 1;
			for (int day = 1; day <= max; day++) {
				sum = 0;
				visited = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheese[i][j] == day) cheese[i][j] = 0;
					}
				}
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (isValid(i, j)) {
							sum++;
							dfs(i, j);
						}
					}
				}
				ans = Math.max(sum, ans);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!isValid(nx, ny)) continue;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n && cheese[x][y] != 0 && !visited[x][y];
	}
}