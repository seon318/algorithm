import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, l;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new int[n + 1][2];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			dp = new int[n + 1][l + 1];
			for (int i = 1; i <= n; i++) {
				for (int c = 1; c <= l; c++) {
					if (arr[i][1] > c) dp[i][c] = dp[i-1][c];
					else dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-arr[i][1]] + arr[i][0]);
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[n][l]).append("\n");
		}
		System.out.println(sb);
	}
}