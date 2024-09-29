import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int[] fare = new int[4];
		int[] dp = new int[13];
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				fare[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				dp[i] = Math.min(Integer.parseInt(st.nextToken()) * fare[0], fare[1]);
			}
			
			dp[2] += dp[1];
			for (int i = 3; i <= 12; i++) {
				dp[i] = Math.min(dp[i] + dp[i-1], dp[i-3] + fare[2]);
			}
					
			sb.append("#").append(tc).append(" ").append(dp[12] > fare[3] ? fare[3] : dp[12]).append("\n");
		}
		System.out.println(sb);
	}
	
}