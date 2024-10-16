import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b, c;
	static int[][] ans;
	static int[][] time;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[n+1][n+1];
		time = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) Arrays.fill(time[i], 1000*n);
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (time[a][b] > c) {
				time[a][b] = c;
				ans[a][b] = b;
			}
			if (time[b][a] > c) {
				time[b][a] = c;
				ans[b][a] = a;
			}
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i) continue;
				for (int j = 1; j <= n; j++) {
					if (k == j || i == j) continue;
					if (time[i][j] > time[i][k] + time[k][j]) {
						time[i][j] = time[i][k] + time[k][j];
						ans[i][j] = ans[i][k];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) sb.append("- ");
				else sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}