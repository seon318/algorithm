import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, r, c, l, time, cnt; 
	static int[][] map;
	static int[] tunnel = {0, 15, 10, 5, 9, 3, 6, 12};
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());			}
			}
			
			visited[r][c] = true;
			queue.add(new int[] {r, c, 1});
			while (!queue.isEmpty()) {
				int[] item = queue.poll();
				r = item[0];
				c = item[1];
				time = item[2];
				if (time == l) break;
				for (int d = 0; d < 4; d++) {
					if ((1 << d & tunnel[map[r][c]]) > 0) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (isValid(nr, nc) && (1 << (d + 2) % 4 & tunnel[map[nr][nc]]) > 0) {
							queue.add(new int[] {nr, nc, time + 1});
							visited[nr][nc] = true;
						}
					}
				}
			}
			queue.clear();
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j]) cnt++;
				}
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m && !visited[x][y];
	}
}