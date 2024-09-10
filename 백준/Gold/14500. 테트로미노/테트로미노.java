import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				check(i, j, 1, paper[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void check(int x, int y, int cnt, int sum) {
		if (cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isValid(nx, ny)) {
				visited[nx][ny] = true;
				check(nx, ny, cnt + 1, sum + paper[nx][ny]);
				check(x, y, cnt + 1, sum + paper[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y];
	}
}