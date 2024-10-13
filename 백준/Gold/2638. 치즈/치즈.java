import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean flag;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] paper;
	static Queue<int[]> queue = new LinkedList<>();
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		
		flag = true;
		while (true) {
			//남은 치즈 있는지 확인 
			flag = false;
			outer : for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (paper[i][j] == 1) {
						flag = true;
						break outer;
					}
				}
			}
			
			if (!flag) {
				System.out.println(time);
				return;
			}
			
			time++;
			
			//외부 공기 여부 확인 
			visited = new boolean[n][m];
			visited[0][0] = true;
			paper[0][0] = 2;
			outside(0, 0);
			

			//치즈가 녹는지 확인
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (paper[i][j] == 1 && melt(i, j) >= 2) {
						queue.add(new int[] {i, j});
					}
				}
			}
			
			//치즈 녹이기 
			while (!queue.isEmpty()) {
				int[] item = queue.poll();
				paper[item[0]][item[1]] = 0;
			}
			
		}
		
    }

	private static void outside(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isValid(nx, ny) && paper[nx][ny] != 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				paper[nx][ny] = 2;
				outside(nx, ny);
			}
		}
	}
	
	private static int melt(int x, int y) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isValid(nx, ny) && paper[nx][ny] == 2) cnt++;
		}
		return cnt;
	}

	private static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
}