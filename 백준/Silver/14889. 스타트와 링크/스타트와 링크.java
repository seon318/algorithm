import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int[][] s;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		selected = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;
		comb(0, 0);

		System.out.println(ans);
	}

	static void comb(int cnt, int idx) {
		if (cnt == n / 2) {
			ans = Math.min(getTasteDiff(), ans);
			return;
		}

		for (int i = idx; i < n; i++) {
			selected[i] = true;
			comb(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

	static int getTasteDiff() {
		int a = 0, b = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (selected[i] && selected[j]) {
					a += s[i][j];
					a += s[j][i];
				} else if (!selected[i] && !selected[j]) {
					b += s[i][j];
					b += s[j][i];
				}
			}
		}
		return Math.abs(a - b);
	}

}