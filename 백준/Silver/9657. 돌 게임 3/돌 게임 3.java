import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n <= 4) {
			if (n == 2) System.out.println("CY");
			else System.out.println("SK");
			return;
		}
		boolean[] dp = new boolean[n + 1];
		dp[1] = true;
		dp[2] = false;
		dp[3] = true;
		dp[4] = true;
		for (int i = 5; i <= n; i++) {
			if (!dp[i - 4] || !dp[i - 3] || !dp[i - 1]) dp[i] = true;
		}
		System.out.println(dp[n] ? "SK" : "CY");
	}

}