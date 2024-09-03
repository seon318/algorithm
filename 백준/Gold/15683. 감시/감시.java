import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, x, y, dir, nx, ny, cnt, ans;
	static int[][] room, matrix;
	static List<int[]> cctv = new ArrayList<>();
	static int[] cctvDir, item;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] > 0 && room[i][j] != 6) {
					cctv.add(new int[] {room[i][j], i, j});
				}
			}
		}
		
		cctvDir = new int[cctv.size()];
		ans = n * m;
		perm(0);
		System.out.println(ans);
	}
	
	static void search() {
		matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = room[i][j];
			}
		}
		
		for (int i = 0; i < cctv.size(); i++) {
			item = cctv.get(i);
			x = item[1];
			y = item[2];
			dir = cctvDir[i];
			
			check(x, y, dir);
			switch (item[0]) {
			case 2 :
				check(x, y, (dir + 2) % 4);
				break;
			case 3 :
				check(x, y, (dir + 1) % 4);
				break;
			case 5 :
				check(x, y, (dir + 3) % 4);
			case 4 :
				check(x, y, (dir + 1) % 4);
				check(x, y, (dir + 2) % 4);
				break;

			}
		}
		
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) cnt++;
			}
		}
		ans = Math.min(cnt, ans);
	}
	
	static void perm(int cnt) {
		if (cnt == cctv.size()) {
			search();
			return;
		}
		
		int repeat = 4;
		int now = cctv.get(cnt)[0];
		if (now == 5) repeat = 1;
		else if (now == 2) repeat = 2;
		
		for (int d = 0 ; d < repeat; d++) {
			cctvDir[cnt] = d;
			perm(cnt + 1);
		}
	}
	
	static void check(int x, int y, int dir) {
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (!isValid(x, y)) return;
			if (matrix[x][y] == 6) return;
			if (matrix[x][y] == 0) matrix[x][y] = -1;
		}

	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}