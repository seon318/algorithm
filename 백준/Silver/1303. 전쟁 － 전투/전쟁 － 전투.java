import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m, cnt, mySum, yourSum;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				if (input.charAt(j) == 'W') arr[i][j] = 0;
				else arr[i][j] = 1;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					cnt = 1;
					visited[i][j] = true;
					dfs(i, j, arr[i][j]);
					if (arr[i][j] == 0) mySum += cnt * cnt;
					else yourSum += cnt * cnt;
				}
			}
		}

		sb.append(mySum).append(' ').append(yourSum);
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int id) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (0 <= nx && nx < m && 0 <= ny && ny < n && !visited[nx][ny] && arr[nx][ny] == id) {
				cnt++;
				visited[nx][ny] = true;
				dfs(nx, ny, id);
			}
		}
	}
}
