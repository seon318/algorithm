import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, k, ans, cnt, max, nx, ny, house;
	static int[] item, houseCnt, area;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] city;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			city = new int[n][n];
			
			house = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
					if (city[i][j] == 1) house++;
				}
			}
			
			max = 1;
			while (house * m >= max * max + (max + 1) * (max + 1)) max++;

			area = new int[max];
			for (int i = 0; i < max; i++) {
				area[i] = (i + 1) * (i + 1) + (i + 2) * (i + 2);
			}

			ans = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[n][n];
					bfs(i, j);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	

	static void bfs(int x, int y) {
		houseCnt = new int[max];
		houseCnt[0] += city[x][y];
		queue.add(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			item = queue.poll();
			for (int d = 0; d < 4; d++) {
				nx = item[0] + dx[d];
				ny = item[1] + dy[d];
				if (nx == x && ny == y) continue;
				if (!isValid(nx, ny) || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				houseCnt[item[2]] += city[nx][ny];
				if (item[2] >= max - 2) continue;
				queue.add(new int[] {nx, ny, item[2] + 1});
			}
		}
		
		cnt = 0;
		for (int i = 0; i < max; i++) {
			cnt += houseCnt[i];
			if (cnt <= ans) continue;
			if (cnt * m >= area[i]) ans = Math.max(cnt, ans);
		}
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
}