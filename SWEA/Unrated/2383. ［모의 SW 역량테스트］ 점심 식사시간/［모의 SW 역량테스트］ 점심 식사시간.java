import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, p, ans, stairLen1, stairLen2;
	static int[][] map, stair1, stair2, distance;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> queue2 = new LinkedList<>();
	static PriorityQueue <Integer> pq1 = new PriorityQueue<>();
	static PriorityQueue <Integer> pq2 = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			p = 0;
			map = new int [n][n];
			int stair1x = -1, stair1y = -1, stair2x = -1, stair2y = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 1) {
						if (stair1x == -1) {
							stair1x = i;
							stair1y = j;
							stairLen1 = map[i][j];
						} else {
							stair2x = i;
							stair2y = j;
							stairLen2 = map[i][j];
						}
					} else if (map[i][j] == 1) p++;
				}
			}
			
			//계단에서 각 사람까지의 최단거리 확인
			stair1 = new int[n][n];
			stair2 = new int[n][n];
			checkDistance(stair1, stair1x, stair1y);
			checkDistance(stair2, stair2x, stair2y);
			
			//사람에서 계단까지의 거리 배열 + 둘 중 무엇을 선택했는지 distance
			distance = new int[p][3];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						distance[idx][0] = stair1[i][j];
						distance[idx++][1] = stair2[i][j];
					}
				}
			}
			
			//어느 계단을 이용할까? -> 조합
			ans = Integer.MAX_VALUE;
			select(0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
		
	static void checkDistance(int[][] arr, int r, int c) {
		queue.add(new int[] {r, c});
		while (!queue.isEmpty()) {
			int[] popItem = queue.poll();
			int x = popItem[0];
			int y = popItem[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (isValid(nx, ny) && arr[nx][ny] == 0 && (nx != r || ny != c)) {
					arr[nx][ny] = arr[x][y] + 1;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static void select(int cnt) {
		if (cnt == p) {
			pq1.clear();
			pq2.clear();
			for (int i = 0; i < p; i++) {
				if (distance[i][2] == 0) {
					pq1.add(distance[i][0]);
				} else {
					pq2.add(distance[i][1]);
				}
			}
			moveStairs();
			
			return;
		}
		
		distance[cnt][2] = 1;
		select(cnt + 1);
		
		distance[cnt][2] = 0;
		select(cnt + 1);
	}
	
	static void moveStairs() {
		int time = 0;
		while (true) {
			time++;
			while (!queue.isEmpty() && queue.peek()[1] <= time) queue.poll();
			while (!queue2.isEmpty() && queue2.peek()[1] <= time) queue2.poll();
			while (!pq1.isEmpty() && queue.size() < 3 && pq1.peek() < time) queue.add(new int[] {pq1.poll(), time + stairLen1});
			while (!pq2.isEmpty() && queue2.size() < 3 && pq2.peek() < time) queue2.add(new int[] {pq2.poll(), time + stairLen2});
			if (pq1.isEmpty() && pq2.isEmpty() && queue.isEmpty() && queue2.isEmpty()) break;
		}
		ans = Math.min(time, ans);
	}
}
