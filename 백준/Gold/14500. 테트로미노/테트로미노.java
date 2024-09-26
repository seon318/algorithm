import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, max;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		max = 0; // 최대 결과 값

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true; // 시작점 방문 체크
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false; // 해지
			}
		}

		System.out.println(max);
	} // main

	static void dfs(int x, int y, int count, int sum) {

		if (count == 4) {
			// 총합 비교
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위체크 -> 방문체크
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					// 긴 모양, 네모 모양, ㄴ 모양, ㄹ 모양
					dfs(nx, ny, count + 1, sum + arr[nx][ny]);
					// T자 모양
					dfs(x, y, count + 1, sum + arr[nx][ny]);
					visited[nx][ny] = false;
				}
			}
		} // 4방향 탐색 끝

	} // dfs

} // class
