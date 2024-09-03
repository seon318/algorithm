import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String input;
		char[][] map;
		int ans, x, y, cnt, nx, ny;
		int[] popItem;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] distance;
		
		
		Queue<int[]> queue = new LinkedList<>();
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				input = br.readLine();
				for (int j = 0; j < m; j++) {
					if (input.charAt(j) == 'W') {
						map[i][j] = 1;
						queue.add(new int[] {i, j});
					}
					
				}
			}
			
			distance = new int[n][m];
			while (!queue.isEmpty()) {
				popItem = queue.poll();
				x = popItem[0];
				y = popItem[1];
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (isValid(nx, ny) && distance[nx][ny] == 0 && map[nx][ny] == 0) {
						distance[nx][ny] = distance[x][y] + 1;
						queue.add(new int[] {nx, ny});
					}
				}
			}
			
			ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					ans += distance[i][j];
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		} 
		System.out.println(sb);
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}
