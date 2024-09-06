import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	static int n, nx, ny, sum;
	static String input;
	static int[] item;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<int[]> path = new PriorityQueue<>((o1, o2) -> {
		return o1[2] - o2[2];
	});
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				input = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			check();
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static void check() {
		visited = new boolean[n][n];
		visited[0][0] = true;
		path.clear();
		path.add(new int[] {0, 0, 0});
		while (!path.isEmpty()) {
			item = path.poll();
			for (int d = 0; d < 4; d++) {
				nx = item[0] + dx[d];
				ny = item[1] + dy[d];
				if (nx == n - 1 && ny == n - 1) {
					sum = item[2];
					return;
				}
				if (isValid(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					path.add(new int[] {nx, ny, item[2] + map[nx][ny]});
				}
			}
			
		}
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}