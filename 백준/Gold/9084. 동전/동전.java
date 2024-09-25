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
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] coin = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			
			int[] dp = new int[m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (j - coin[i] > 0) {
						dp[j] += dp[j - coin[i]];
					} else if (j - coin[i] == 0) dp[j]++;
				}
			}
			System.out.println(dp[m]);
		}
		
	}
}