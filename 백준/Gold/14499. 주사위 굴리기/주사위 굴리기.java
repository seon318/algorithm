import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[] dx = { 0, 0, 0, -1, 1 };
		int[] dy = { 0, 1, -1, 0, 0 };
		int[] dice = new int[6];
		int[] pair = {5, 4, 3, 2, 1, 0};

		// top, north, east
		int[] side = {0, 1, 2};

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int command = Integer.parseInt(st.nextToken());

			int nx = x + dx[command];
			int ny = y + dy[command];

			if (0 > nx || nx >= n || 0 > ny || ny >= m)
				continue;

			// 지도에서 해당 좌표 옮기고 이동 후 side 갱신 
			x = nx;
			y = ny;
			
			int tmp;
			if (command == 1) {
				tmp = side[0];
				side[0] = pair[side[2]];
				side[2] = tmp;
			} else if (command == 2) {
				tmp = side[2];
				side[2] = pair[side[0]];
				side[0] = tmp;
			} else if (command == 3) {
				tmp = side[0];
				side[0] = pair[side[1]];
				side[1] = tmp;
			} else if (command == 4) {
				tmp = side[1];
				side[1] = pair[side[0]];
				side[0] = tmp;
			}

			sb.append(dice[side[0]]).append('\n');

			// 아랫면 또는 지도 값 변화
			int bottom = pair[side[0]];
			if (arr[x][y] == 0) {
				arr[x][y] = dice[bottom];
			} else {
				dice[bottom] = arr[x][y];
				arr[x][y] = 0;
			}
			
		}

		System.out.println(sb);

	}
}