import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n, k, ans, len;
		int[][] puzzle;
		boolean[][] visited;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			puzzle = new int[n][n];
			visited = new boolean[n][n];
			ans = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				out: for (int j = 0; j < n; j++) {
					if (puzzle[i][j] == 0 || visited[i][j] == true)
						continue;
					if (puzzle[i][j] == 1) {
						visited[i][j] = true;
						len = 1;
						while (true) {
							if (j + len < n && puzzle[i][j + len] == 1) {
								visited[i][j + len++] = true;
							} else break;
						}
						if (len == k) ans++;
					}
				}
			}
			
			visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				out: for (int j = 0; j < n; j++) {
					if (puzzle[i][j] == 0 || visited[i][j] == true)
						continue;
					if (puzzle[i][j] == 1) {
						visited[i][j] = true;
						len = 1;
						while (true) {
							if (i + len < n && puzzle[i + len][j] == 1) {
								visited[i + len++][j] = true;
							} else break;
						}
						if (len == k) ans++;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
