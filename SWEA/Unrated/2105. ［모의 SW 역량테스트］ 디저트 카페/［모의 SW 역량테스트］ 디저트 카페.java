import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n, ans;
	static int[][] map;
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<Integer> dessertList;
		Deque<Integer> moveDir;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = -1;
			for (int i = 0; i <= n - 3; i++) {
				for (int j = 1; j <= n - 2; j++) {
					dessertList = new ArrayList<>();
					moveDir = new ArrayDeque<>();
					dessertList.add(map[i][j]);
					move(i, j, 0, false, dessertList, moveDir);
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
			
		}
		System.out.println(sb);
	}
	
	static void move(int x, int y, int d, boolean isBack, List<Integer> dessertList, Deque<Integer> moveDir) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		List<Integer> list = new ArrayList<>(dessertList);
		Deque<Integer> dir = new ArrayDeque<>(moveDir);
		if (!isValid(nx, ny) || list.contains(map[nx][ny])) return;
		if (!isBack) dir.add(d);
		list.add(map[nx][ny]);
		if (isBack && dir.size() == 1) {
			ans = Math.max(ans, list.size());
		} else if (isBack) {
			move(nx, ny, (dir.pollFirst() + 2) % 4, true, list, dir);
		} else if (!isBack && d == 0) {
			move(nx, ny, 0, false, list, dir);
			move(nx, ny, 1, false, list, dir);
		} else if (!isBack && d == 1) {
			move(nx, ny, 1, false, list, dir);
			move(nx, ny, (dir.pollFirst() + 2) % 4, true, list, dir);
		}
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
	
}