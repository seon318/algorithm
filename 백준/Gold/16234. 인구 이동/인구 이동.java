import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, l, r, sum;
	static int[][] ground;
	static boolean canMove;
	static boolean[][] visited;
	static List<int[]> union = new ArrayList<>();
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		ground = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;

		// 움직일 수 있는 동안 반복
		while (true) {
			canMove = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j])
						continue;
					getUnion(i, j);
				}
			}

			if (!canMove)
				break;
			day++;
		}

		System.out.println(day);
	}

	static boolean isValid(int nx, int ny, int x, int y) {
		if (0 > nx || nx >= n || 0 > ny || ny >= n || visited[nx][ny])
			return false;
		int diff = Math.abs(ground[x][y] - ground[nx][ny]);
		if (l <= diff && diff <= r)
			return true;
		return false;
	}

	static void getUnion(int i, int j) {
		union.clear();
		sum = 0;
		queue.add(new int[] { i, j });
		union.add(new int[] { i, j });
		sum += ground[i][j];
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] popItem = queue.poll();
			int x = popItem[0];
			int y = popItem[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (isValid(nx, ny, x, y)) {
					queue.add(new int[] { nx, ny });
					union.add(new int[] { nx, ny });
					sum += ground[nx][ny];
					visited[nx][ny] = true;
				}
			}
		}
		
		if (union.size() > 1) {
			int num = sum / union.size();
			for (int[] loc : union) {
				ground[loc[0]][loc[1]] = num;
				canMove = true;
			}
		}
	}
}