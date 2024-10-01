import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp;
		int ans;
		
		if (n == 0) ans = 0;
		else if (n > 0) {
			dp = new int[n+1];
			dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				dp[i] = (dp[i-2]+dp[i-1])%1000000000;
			}
			ans = dp[n];
		} else {
			dp = new int[-n+1];
			dp[1] = 1;
			for (int i = 2; i <= -n; i++) {
				dp[i] = (dp[i-2]-dp[i-1])%1000000000;
			}
			ans = dp[-n];
		}
		
		System.out.println(ans > 0 ? 1 : ans == 0 ? 0 : -1);
		System.out.println(Math.abs(ans));
		
	}
	
}