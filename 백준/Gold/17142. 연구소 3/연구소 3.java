import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, nx, ny, max, ans;
	static boolean flag;
	static int[] tmp, sel;
	static int[][] lab, matrix;
	static List<int[]> virus;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		lab = new int[n][n];
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		
		sel = new int[m];
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		if (ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
	static void comb(int cnt, int idx) {
		if (cnt == m) {
			matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (lab[i][j] == 1) matrix[i][j] = -1;
				}
			}
			
			for (int i = 0; i < m; i++) {
				queue.add(new int[] {virus.get(sel[i])[0], virus.get(sel[i])[1], 0});
			}

			while (!queue.isEmpty()) {
				tmp = queue.poll();
				for (int d = 0; d < 4; d++) {
					nx = tmp[0] + dx[d];
					ny = tmp[1] + dy[d];
					if (!isValid(nx, ny) || matrix[nx][ny] != 0) continue;
					matrix[nx][ny] = tmp[2] + 1;
					queue.add(new int[] {nx, ny, tmp[2] + 1});
				}
			}
			max = 0;

			for (int i = 0; i < virus.size();i ++) {
				matrix[virus.get(i)[0]][virus.get(i)[1]] = -1;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == -1) continue;
					if (matrix[i][j] == 0) return;
					max = Math.max(max, matrix[i][j]);
				}
			}
			ans = Math.min(ans, max);
			return;
		}
		
		for (int i = idx; i < virus.size(); i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}