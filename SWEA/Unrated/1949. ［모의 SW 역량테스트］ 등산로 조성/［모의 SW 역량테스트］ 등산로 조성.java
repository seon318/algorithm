import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] ground;
	static int n, k, max_len;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int max_h;
		boolean[][] visited;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ground = new int[n][n];
			visited = new boolean[n][n];

			max_h = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					ground[i][j] = Integer.parseInt(st.nextToken());
					max_h = Math.max(max_h, ground[i][j]);
				}
			}

			max_len = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (ground[i][j] == max_h) {
						visited[i][j] = true;
						dfs(i, j, max_h, 1, true, visited);
						visited[i][j] = false;
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(max_len).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y, int h, int len, boolean isPossible, boolean[][] visited) {
		max_len = Math.max(max_len, len);
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (isValid(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				if (ground[nx][ny] >= h && isPossible && h > ground[nx][ny] - k) {
					dfs(nx, ny, h - 1, len + 1, false, visited);
				} else if (ground[nx][ny] < h) {
					dfs(nx, ny, ground[nx][ny], len + 1, isPossible, visited);
				}
				visited[nx][ny] = false;
			}
		}
	}
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
}