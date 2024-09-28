import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] maze = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][m];
		dp[0][0] = maze[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][0] + maze[i][0];
		}
		for (int j = 1; j < m; j++) {
			dp[0][j] = dp[0][j-1] + maze[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = maze[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}
		System.out.println(dp[n-1][m-1]);
	}
}