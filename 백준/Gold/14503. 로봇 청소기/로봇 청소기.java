import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt, nr, nc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while (true) {
			if (room[r][c] == 0) {
				room[r][c] = -1;
				ans++;
			}
			
			cnt = 0;
			for (int k = 0; k < 4; k++) {
				nr = r + dr[k];
				nc = c + dc[k];
				if (isValid(nr, nc) && room[nr][nc] == 0) cnt++;
			}
			
			//청소되지 않은 칸 없는 경우
			if (cnt == 0) {
				nr = r + dr[(d + 2) % 4];
				nc = c + dc[(d + 2) % 4];
				if (isValid(nr, nc)) {
					if (room[nr][nc] == 1) break;
					r = nr;
					c = nc;
				} else {
					break;
				}
			} else {
				while (true) {
					d = (d + 3) % 4;
					nr = r + dr[d];
					nc = c + dc[d];
					if (isValid(nr, nc) && room[nr][nc] == 0) {
						r = nr;
						c = nc;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}
