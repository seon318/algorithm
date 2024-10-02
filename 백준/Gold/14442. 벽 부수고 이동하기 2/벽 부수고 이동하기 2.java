import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, x, y, depth, dist, nx, ny;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		String input;
		int[] now;
		
		boolean[][] map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j) == '0' ? true : false;
			}
		}
		
		boolean[][][] visited = new boolean[n][m][k+1];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;
		
		int ans = Integer.MAX_VALUE;
		
		while (!queue.isEmpty()) {
			now = queue.poll();
			x = now[0];
			y = now[1];
			depth = now[2];
			dist = now[3];
			
			if (x == n-1 && y == m-1) {
				ans = Math.min(ans, dist);
			}
			
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];
				if (!isValid(nx, ny)) continue;
				//이동할 수 있는 칸
				if (map[nx][ny]) {
                    if (!visited[nx][ny][depth]) {
					    visited[nx][ny][depth] = true;
					    queue.add(new int[] {nx, ny, depth, dist+1});
                    }
				}
				//벽 뚫고 가는 경우
				else {
                    if (depth < k && !visited[nx][ny][depth+1]) {
					    visited[nx][ny][depth+1] = true;
					    queue.add(new int[] {nx, ny, depth+1, dist+1});
                    }
				}
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}