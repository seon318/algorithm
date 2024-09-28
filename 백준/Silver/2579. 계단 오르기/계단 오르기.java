import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(br.readLine());
			return;
		}
		
		int[] stair = new int[n+1];
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
			dp[i] = stair[i];
		}
		
		dp[2] += stair[1];
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(stair[i-1] + dp[i-3], dp[i-2]) + stair[i];
		}
		System.out.println(dp[n]);
	}
}