import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n, idx, maxCore, minLen, coreLen, cnt;
	static boolean[][] visited;
	static List<int[]> cores;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t ; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			visited = new boolean[n][n];
			idx = 0;
			cnt = 0;
			cores = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					if (st.nextToken().equals("0")) continue;
					visited[i][j] = true;
					if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
						cnt++;
						continue;
					}
					cores.add(new int[] {i, j});
				}
			}
			
			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			coreLen = cores.size();
			
			comb(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minLen).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx, int len) {
		if (cnt > maxCore) {
			maxCore = cnt;
			minLen = len;
		}
		
		if (cnt == maxCore && minLen > len) minLen = len;
		
		if (cnt == coreLen) {
			return;
		}
		
		for (int i = idx; i < coreLen; i++) {
			int x = cores.get(i)[0];
			int y = cores.get(i)[1];
			for (int d = 0; d < 4; d++) {
				int length = link(x, y, d);
				if (length > 0) {
					comb(cnt + 1, i + 1, len + length);
					unlink(x, y, d);
				}
			}
		}
	}
	
	static int link(int x, int y, int d) {
		if (d == 0) {
			for (int i = 0; i < x; i++) if (visited[i][y]) return 0;
			for (int i = 0; i < x; i++) visited[i][y] = true;
			return x;
		}
		
		else if (d == 1) {
			for (int i = 0; i < y; i++) if (visited[x][i]) return 0;
			for (int i = 0; i < y; i++) visited[x][i] = true;
			return y;
		}
		
		else if (d == 2) {
			for (int i = n - 1; i > x; i--) if (visited[i][y]) return 0;
			for (int i = n - 1; i > x; i--) visited[i][y] = true;
			return n - x - 1;
		}
		
		else {
			for (int i = n - 1; i > y; i--) if (visited[x][i]) return 0;
			for (int i = n - 1; i > y; i--) visited[x][i] = true;
			return n - y - 1;
		}
	}
	
	static void unlink(int x, int y, int d) {
		if (d == 0) for (int i = 0; i < x; i++) visited[i][y] = false;
		else if (d == 1) for (int i = 0; i < y; i++) visited[x][i] = false;
		else if (d == 2) for (int i = n - 1; i > x; i--) visited[i][y] = false;
		else for (int i = n - 1; i > y; i--) visited[x][i] = false;
		
	}

}