import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper = new int[10][10];
	static int[] result = new int[6];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);
		br.close();
	}

	public static void dfs(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (ans <= cnt)
			return;

		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}

		if (paper[x][y] == 1) {
			for (int i = 5; i > 0; i--) {
				if (result[i] < 5 && isAttach(x, y, i)) {
					attach(x, y, i, 0);
					result[i]++;
					dfs(x, y + 1, cnt + 1);
					attach(x, y, i, 1);
					result[i]--;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}
	}

	public static void attach(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				paper[i][j] = state;
			}
		}
	}

	public static boolean isAttach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}

				if (paper[i][j] != 1) {
					return false;
				}
			}
		}
		return true;

	}
}