import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int r, c, nx, ny;
	static boolean canMove = false;
	static char[][] farm;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		farm = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			farm[i] = br.readLine().toCharArray();
		}
		
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (farm[i][j] == 'W') {
					check(i, j);
				}
			}
		}
		
		
		
		if (canMove) {
			bw.append('0');
		} else {
			bw.append("1\n");
			for (int i = 0; i < r; i++) {
				bw.append(String.valueOf(farm[i]) + "\n");
			}
		}
		
		bw.flush();
	}
	
	static void check(int x, int y) {
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny]) {
				if (farm[nx][ny] == 'S') {
					if (farm[x][y] == '.') {
						farm[x][y] = 'D';
						return;
					} else {
						canMove = true;
						return;
					}
					
				} else check(nx, ny);
			}
		}
	}
}
