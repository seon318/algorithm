import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] room;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		String input;
		
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			for (int j = 0; j < m; j++) {
				if (input.charAt(j) == '-') room[i][j] = 1;
				else room[i][j] = 2;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (room[i][j] != 0) {
					int tmp = room[i][j];
					room[i][j] = 0;
					cnt++;
					dfs(i, j, tmp);
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int k) {
		int start = k % 2 == 0 ? 0 : 1;
		for (int d = start; d < 4; d+= 2) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isValid(nx, ny, k)) continue; 
			room[nx][ny] = 0;
			dfs(nx, ny, k);
		}
		
	}

	private static boolean isValid(int x, int y, int z) {
		return x >= 0 && x < n && y >= 0 && y < m && room[x][y] == z;
	}
}