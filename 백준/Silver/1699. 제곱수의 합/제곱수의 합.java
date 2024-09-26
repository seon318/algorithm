import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 10000);
		for (int i = 1; i*i <= n; i++) {
			dp[i*i] = 1;
		}
		
		int x = 1;
		for (int i = 2; i <= n; i++) {
			if (dp[i] == 1) x++;
			for (int j = 1; j <= x; j++) {
				dp[i] = Math.min(dp[j*j] + dp[i - j*j], dp[i]);
			}
		}
		
		System.out.println(dp[n]);
	}
}

