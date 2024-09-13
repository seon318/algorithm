import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T, x, d, k, nx, ny, val, cnt, sum;
	static double avg;
	static int[][] arr;
	static int[] idx, now;
	static boolean flag, isMoved;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dy = { 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		idx = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			// 원판 돌리기
			for (int i = x; i <= N; i += x) {
				if (d == 0)
					idx[i - 1] = (idx[i - 1] - k + M) % M;
				else
					idx[i - 1] = (idx[i - 1] + k) % M;
			}

			isMoved = false;
			for (int i = 0; i < N; i++) {
				for (int j = idx[i]; j < idx[i] + M; j++) {
					if (arr[i][j % M] == 0)
						continue;
					queue.add(new int[] { i, j % M });
					val = arr[i][j % M];
					flag = false;

					while (!queue.isEmpty()) {
						now = queue.poll();

						// 상 탐색
						if (now[0] > 0) {
							nx = now[0] - 1;
							ny = (now[1] - idx[now[0]] + idx[nx] + M) % M;
							if (arr[nx][ny] == val) {
								queue.add(new int[] { nx, ny });
								arr[nx][ny] = 0;
								flag = true;
							}
						}
						
						// 하 탐색
						if (now[0] < N - 1) {
							nx = now[0] + 1;
							ny = (now[1] - idx[now[0]] + idx[nx] + M) % M;
							if (arr[nx][ny] == val) {
								queue.add(new int[] { nx, ny });
								arr[nx][ny] = 0;
								flag = true;
							}
						}

						// 좌우 탐색
						for (int d = 0; d < 2; d++) {
							nx = now[0];
							ny = (now[1] + dy[d] + M) % M;
							if (arr[nx][ny] == val) {
								queue.add(new int[] { nx, ny });
								arr[nx][ny] = 0;
								flag = true;
							}
						}

					}
					if (flag) {
						isMoved = true;
						arr[i][j % M] = 0;
					}
				}
			}

			if (!isMoved) {
				sum = 0;
				cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (arr[i][j] == 0)
							continue;
						sum += arr[i][j];
						cnt++;
					}
				}
				if (cnt == 0)
					break;
				avg = (double) sum / cnt;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (arr[i][j] == 0)
							continue;
						if (arr[i][j] > avg)
							arr[i][j] -= 1;
						else if (arr[i][j] < avg)
							arr[i][j] += 1;
					}
				}
			}

		}

		sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += arr[i][j];

			}
		}

		System.out.println(sum);
	}

}