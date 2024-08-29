import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, x, height, ans;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			for (int i = 0; i < n; i++) {
				checkRow(i);
				checkCol(i);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void checkRow(int i) {
		visited = new boolean[n];

		height = map[i][0];
		for (int j = 1; j < n; j++) {
			if (map[i][j] != height) {
				if (Math.abs(map[i][j] - height) > 1) return;
				if (map[i][j] > height) {
					for (int idx = j - 1; idx >= j - x; idx--) {
						if (idx < 0 || map[i][idx] != height || visited[idx]) return;
						visited[idx] = true;
					}
					height = map[i][j];
				} else {
					height = map[i][j];
					for (int k = 1; k < x; k++) {
						if (++j == n || map[i][j] != height || visited[j]) return;
						visited[j] = true;
					}
				}
			}
		}
		ans++;
	}
	
	static void checkCol(int j) {
		visited = new boolean[n];
		height = map[0][j];
		for (int i = 1; i < n; i++) {
			if (map[i][j] != height) {
				if (Math.abs(map[i][j] - height) > 1) return;
				if (map[i][j] > height) {
					for (int idx = i - 1; idx >= i - x; idx--) {
						if (idx < 0 || map[idx][j] != height || visited[idx]) return;
						visited[idx] = true;
					}
					height = map[i][j];
				} else {
					height = map[i][j];
					for (int k = 1; k < x; k++) {
						if (++i == n || map[i][j] != height || visited[i]) return;
						visited[i] = true;
					}
				}
			}
		}
		ans++;
	}
}
