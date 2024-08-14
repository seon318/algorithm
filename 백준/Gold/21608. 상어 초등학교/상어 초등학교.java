import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, nr, nc, cnt, sum, now;
	static int[][] seat, likes;
	static PriorityQueue<Candi> tmpSeat = new PriorityQueue<>(
			(o1, o2) -> {
			if (o1.like != o2.like) return Integer.compare(o2.like, o1.like);
			if (o1.empty != o2.empty) return Integer.compare(o2.empty, o1.empty);
			if (o1.r != o2.r) return Integer.compare(o1.r, o2.r);
			if (o1.c != o2.c) return Integer.compare(o1.c, o2.c);
			return 0;
			});
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		seat = new int[n][n];
		likes = new int[n * n][5];

		for (int i = 0; i < n * n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				likes[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n * n; i++) {
			Candi bestSeat = findSeat(i);
			seat[bestSeat.r][bestSeat.c] = likes[i][0];
		}

		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				now = seat[i][j];
				for (int s = 0; s < n * n; s++) {
					if (now == likes[s][0]) {
						now = s;
						break;
					}
				}
				now = getLikeSum(i, j, now);
				if (now == 1) ans += 1;
				else if (now == 2) ans += 10;
				else if (now == 3) ans += 100;
				else if (now == 4) ans += 1000;
			}
		}
		
		sb.append(ans);
		System.out.println(sb);
	}

	static Candi findSeat(int idx) {
		tmpSeat.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (seat[i][j] == 0) {
					tmpSeat.add(new Candi(getLikeSum(i, j, idx), getEmptySum(i, j), i, j));
				}
			}
		}
		return tmpSeat.poll();
	}

	static int getLikeSum(int r, int c, int idx) {
		sum = 0;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if (0 <= nr && nr < n && 0 <= nc && nc < n) {
				for (int s = 1; s < 5; s++) {
					if (seat[nr][nc] == likes[idx][s]) {
						sum++;
						break;
					}
				}
			}
		}
		return sum;
	}

	static int getEmptySum(int r, int c) {
		sum = 0;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if (0 <= nr && nr < n && 0 <= nc && nc < n && seat[nr][nc] == 0) {
				sum++;
			}
		}
		return sum;
	}

}

class Candi {
	int like, empty, r, c;

	public Candi(int like, int empty, int r, int c) {
		this.like = like;
		this.empty = empty;
		this.r = r;
		this.c = c;
	}
}