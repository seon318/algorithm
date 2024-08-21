import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
	static int w, h, cnt;
	static boolean[][] visited;
	static int[][] map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
						
			Queue<int[]> queue = new LinkedList<>();
			
			cnt = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						visited[i][j] = true;
						queue.add(new int[] {i, j});
						while (!queue.isEmpty()) {
							int[] tmp = queue.poll();
							for (int d = 0; d < 8; d++) {
								int nx = tmp[0] + dx[d];
								int ny = tmp[1] + dy[d];
								
								if (isValid(nx, ny)) {
									visited[nx][ny] = true;
									queue.add(new int[] {nx, ny});
								}
							}
						}

					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < h && 0 <= y && y < w && !visited[x][y] && map[x][y] == 1;
	}
}
