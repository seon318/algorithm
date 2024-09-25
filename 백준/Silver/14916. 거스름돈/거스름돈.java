import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] dp;
		if (n <= 5) dp = new int[6];
		else dp = new int[n + 1];
		
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;
		for (int i = 6; i <= n; i++) {
			if (dp[i - 2] == -1) dp[i] = dp[i - 5] + 1;
			else if (dp[i - 5] == -1) dp[i] = dp[i - 2] + 1;
			else if (dp[i - 2] == -1 && dp[i - 5] == -1) dp[i] = -1;
			else dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
		}
		System.out.println(dp[n]);
	}
}