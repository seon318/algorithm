import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int p;
	static int[] fare = new int[4];
	static int[] month = new int[12];
	static int[] dp = new int[12];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				fare[i] = Integer.parseInt(st.nextToken());
			}
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				p = Integer.parseInt(st.nextToken());
				month[i] = Math.min(p * fare[0], fare[1]);
			}
						
			dp[0] = month[0];
			dp[1] = month[0] + month[1];
			dp[2] = Math.min(month[0] + month[1] + month[2], fare[2]);
			for (int i = 3; i < 12; i++) {
				dp[i] = Math.min(dp[i - 1] + month[i], dp[i - 3] + fare[2]);
			}
			
			sb.append("#").append(tc).append(" ").append(Math.min(dp[11], fare[3])).append("\n");
		}
		System.out.println(sb);
	}
}