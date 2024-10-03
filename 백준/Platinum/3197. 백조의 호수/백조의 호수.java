import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		Queue<int[]> water = new LinkedList<>();

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		boolean[][] isWater = new boolean[r][c];
		int[][] lake = new int[r][c];
		int[][] dist = new int[r][c];

		boolean flag = false;
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				if (input.charAt(j) == 'X')
					continue;
				isWater[i][j] = true;
				water.add(new int[] { i, j, 0 });

				if (input.charAt(j) == 'L') {
					queue.add(new int[] { i, j, 0});
					if (!flag) {
						lake[i][j] = 1;
						flag = true;
					} else
						lake[i][j] = 2;
				}
			}
		}
		int[] item;
		int x, y, z, num, nx, ny;
		int day = 0;
		int ans = Integer.MAX_VALUE;
		while (true) {
			//백조끼리 만나는지 확인하기 
			while (!queue.isEmpty() && queue.peek()[2] == day) {
				item = queue.poll();
				x = item[0];
				y = item[1];
				z = item[2];
				num = lake[x][y];
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || lake[nx][ny] == num )
						continue;
					if (lake[nx][ny] != 0) {
						ans = Math.min(ans, dist[nx][ny]);
						continue;
					}
					lake[nx][ny] = num;
					if (isWater[nx][ny]) dist[nx][ny] = z;
					else dist[nx][ny] = z + 1;
					queue.add(new int[] { nx, ny, dist[nx][ny] });
				}
			}

			if (ans != Integer.MAX_VALUE) break;
			
			//빙판 녹이기 
			while (!water.isEmpty() && water.peek()[2] == day) {
				item = water.poll();
				x = item[0];
				y = item[1];
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || isWater[nx][ny]) continue;
					isWater[nx][ny] = true;
					water.add(new int[] {nx, ny, day + 1});
				}

			}
			day++;
		}
		
		System.out.println(ans);

	}

}