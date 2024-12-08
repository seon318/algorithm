import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static final int INF = 16_000_000;
	static int[][] cost, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int ans = tsp(0, 1);
		System.out.println(ans);
	}

	static int tsp(int pos, int mask) {
		if (mask == (1 << n) - 1) {
			return cost[pos][0] == 0 ? INF : cost[pos][0];
		}
		
		if (dp[pos][mask] != -1) return dp[pos][mask];
		
		dp[pos][mask] = INF;
		
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0 && cost[pos][i] != 0) {
				dp[pos][mask] = Math.min(tsp(i, mask | (1 << i)) + cost[pos][i], dp[pos][mask]);
			}
		}
		
		return dp[pos][mask];
	}
}