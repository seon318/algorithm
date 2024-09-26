import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[3][n + 1];
		Arrays.fill(dp[0], 1);
		Arrays.fill(dp[1], 1);
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
			}
		}
		
		for (int i = n - 1; i > 0; i--) {
			for (int j = n; j > i; j--) {
				if (arr[i] > arr[j]) dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			dp[2][i] = dp[0][i] + dp[1][i] - 1;
			ans = Math.max(ans, dp[2][i]);
		}
		
		System.out.println(ans);
	}
}