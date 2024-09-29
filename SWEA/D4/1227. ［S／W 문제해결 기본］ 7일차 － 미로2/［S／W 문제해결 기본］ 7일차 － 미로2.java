import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int nx, ny, t, startX, startY, endX, endY;
	static boolean isPossible;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		
		for (int tc = 1; tc <= 10; tc++) {
			t = Integer.parseInt(br.readLine());
			visited = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				input = br.readLine();
				for (int j = 0; j < 100; j++) {
					if (input.charAt(j) == '1') visited[i][j] = true;
					else if (input.charAt(j) == '2') {
						startX = i;
						startY = j;
					} else if (input.charAt(j) == '3') {
						endX = i;
						endY = j;
					}
				}
			}
			isPossible = false;
			dfs(startX, startY);
					
			sb.append("#").append(t).append(" ").append(isPossible ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (0 <= nx && nx < 100 && 0 <= ny && ny < 100 && !visited[nx][ny]) {
				if (nx == endX && ny == endY) {
					isPossible = true;
					return;
				}
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
	
}