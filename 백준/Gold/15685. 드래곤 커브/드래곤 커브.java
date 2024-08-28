import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, x, y, d, g, ans;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean[][] arr = new boolean[101][101];
	static int[] dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			makeCurve();
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 1][j + 1])
					ans++;
			}
		}

		System.out.println(sb.append(ans));

	}

	static void makeCurve() {
		arr[x][y] = true;

		dir = new int[1 << g];
		dir[0] = d;
		int idx = 1;
		for (int i = 1; i <= g; i++) {
			for (int j = (1 << i - 1) - 1; j >= 0; j--) {
				dir[idx++] = (dir[j] + 1) % 4;
			}
		}

		for (int i = 0; i < dir.length; i++) {
			x += dx[dir[i]];
			y += dy[dir[i]];
			arr[x][y] = true;
		}
	}

}