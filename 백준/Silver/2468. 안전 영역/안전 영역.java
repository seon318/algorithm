import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {;
	static int n;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 1;
		for (int h = 0; h <= 100; h++) {
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] <= h) visited[i][j] = true;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			} 
			
			if (cnt == 0) break;
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isValid(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
}