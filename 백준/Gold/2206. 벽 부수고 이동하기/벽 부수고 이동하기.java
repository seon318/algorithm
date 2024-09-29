import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1, 0});
		boolean[][][] visited = new boolean[n][m][2];
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int x = item[0];
			int y = item[1];
			int dist = item[2];
			int flag = item[3];
			if (x == n - 1 && y == m - 1) {
				System.out.println(dist);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = item[0] + dx[d];
				int ny = item[1] + dy[d];
				if (!isValid(nx, ny)) continue;
				if (map[nx][ny] == 0) {
					if (flag == 0 && !visited[nx][ny][0]) {
						queue.add(new int[] {nx, ny, dist + 1, 0});
						visited[nx][ny][0] = true;
					} else if (flag == 1 && !visited[nx][ny][1]) {
						queue.add(new int[] {nx, ny, dist + 1, 1});
						visited[nx][ny][1] = true;
					}
				} else if (map[nx][ny] == 1) {
					if (flag == 0) {
						queue.add(new int[] {nx, ny, dist + 1, 1});
						visited[nx][ny][1] = true;
					}
				}
				
			}
		}
		System.out.println(-1);
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}