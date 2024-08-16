import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int[] cost = new int[4];
		int[] month = new int[13];
		int[] dp = new int[13];
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Math.min(Integer.parseInt(st.nextToken()) * cost[0], cost[1]);
			}

			dp[1] = month[1];
			dp[2] = month[2] + dp[1];
			dp[3] = Math.min(month[3] + dp[2], cost[2]);
			dp[4] = Math.min(month[4] + dp[3], cost[2] + month[1]);
			for (int i = 4; i <= 12; i++) {
				dp[i] = Math.min(month[i] + dp[i-1], cost[2] + dp[i - 3]);
			}
			
			sb.append('#').append(tc).append(' ').append(Math.min(dp[12], cost[3])).append('\n');
		}
		System.out.println(sb);
	}
}