import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt, ans;
	static int[][] map, new_matrix;
	static List<int[]> cctv = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if  (map[i][j] > 0 && map[i][j] != 6) cctv.add(new int[] {map[i][j], i, j});
			}
		}

		ans = n * m;
		check(0, map);
		System.out.println(ans);
	}
	
	static void check(int idx, int[][] matrix) {
		if (idx == cctv.size()) {
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (matrix[i][j] == 0) cnt++;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		int[] item = cctv.get(idx);
		
		//1번 CCTV
		if (item[0] == 1) {
			for (int d = 0; d < 4; d++) {
				new_matrix = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						new_matrix[i][j] = matrix[i][j];
					}
				}
				checkDir(item[1], item[2], d);
				check(idx + 1, new_matrix);
			}
		}
		
		//2번 CCTV
		else if (item[0] == 2) {
			for (int d = 0; d < 2; d++) {
				new_matrix = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						new_matrix[i][j] = matrix[i][j];
					}
				}
				checkDir(item[1], item[2], d);
				checkDir(item[1], item[2], d + 2);
				check(idx + 1, new_matrix);
			}
		}

		//3번 CCTV
		else if (item[0] == 3) {
			for (int d = 0; d < 4; d++) {
				new_matrix = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						new_matrix[i][j] = matrix[i][j];
					}
				}
				checkDir(item[1], item[2], d);
				checkDir(item[1], item[2], (d + 1) % 4);
				check(idx + 1, new_matrix);
			}
		}
		
		//4번 CCTV
		else if (item[0] == 4) {
			for (int d = 0; d < 4; d++) {
				new_matrix = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						new_matrix[i][j] = matrix[i][j];
					}
				}
				checkDir(item[1], item[2], d);
				checkDir(item[1], item[2], (d + 1) % 4);
				checkDir(item[1], item[2], (d + 2) % 4);
				check(idx + 1, new_matrix);
			}
		}
		
		//5번 CCTV
		else {
			new_matrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					new_matrix[i][j] = matrix[i][j];
				}
			}
			checkDir(item[1], item[2], 0);
			checkDir(item[1], item[2], 1);
			checkDir(item[1], item[2], 2);
			checkDir(item[1], item[2], 3);
			check(idx + 1, new_matrix);
		}
		
	}

	static void checkDir(int x, int y, int d) {
		while (true) {
			x += dx[d];
			y += dy[d];
			if (isValid(x, y)) {
				if (new_matrix[x][y] == 6) break;
				else if (new_matrix[x][y] == 0) new_matrix[x][y] = -1;
			} else break;
		}
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}
