import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x, y, l, h;

		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[1002][1002];
		int[] sum = new int[n + 1];

		for (int t = 1; t <= n; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + l; i++) {
				for (int j = y; j < y + h; j++) {
					paper[i][j] = t;
				}
			}
		}
		for (int i = 0; i <= 1001; i++) {
			for (int j = 0; j <= 1001; j++) {
				sum[paper[i][j]]++;
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(sum[i]);
		}
	}
}