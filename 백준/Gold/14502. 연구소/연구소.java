import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans, safe;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited, visit;
	static List<int[]> wall, virus;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		visit = new boolean[n][m];
		wall = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) wall.add(new int[] {i, j});
				else if (map[i][j] == 1) visited[i][j] = true;
				else virus.add(new int[] {i, j});
			}
		}
		
		ans = 0;
		comb(0, 0);
		
		System.out.println(ans);
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == 3) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visit[i][j] = visited[i][j];
				}
			}
			
			for (int[] v : virus) {
				if (visit[v[0]][v[1]]) continue;
				visit[v[0]][v[1]] = true;
				dfs(v[0], v[1]);
			}
			
			safe = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visit[i][j]) safe++;
				}
			}
			ans = Math.max(safe, ans);
			
			return;
		}
		
		for (int i = idx; i < wall.size(); i++) {
			visited[wall.get(i)[0]][wall.get(i)[1]] = true;
			comb(cnt + 1, i + 1);
			visited[wall.get(i)[0]][wall.get(i)[1]] = false;
		}

	}
	
	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isValid(nx, ny)) continue;
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n  && y >= 0 && y < m && !visit[x][y];
	}
}
