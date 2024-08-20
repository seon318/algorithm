import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		
		dp[0] = 1;
		
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				dp[i] = dp[i-1] * i;
			}
		}
		
		System.out.println(dp[n]);
	}
}
