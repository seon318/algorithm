import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] adjArr = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(adjArr[i], n * m);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjArr[a][b] = 1;
			adjArr[b][a] = 1;
		}
	
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (adjArr[i][k] == n * m || adjArr[k][j] == n * m) continue;
					adjArr[i][j] = Math.min(adjArr[i][j], adjArr[i][k] + adjArr[k][j]);
				}
			}
		}
		
		int min = n * m;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				sum += adjArr[i][j];
			}
			if (min > sum) {
				min = sum;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}
}