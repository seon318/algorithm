import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n, num;
		int[][] dp = new int[5000][7];
		int[] coin = {1, 5, 10, 50, 100, 500, 1000};
		int idx = 0;
		for (int i = 1; i < 5; i++) {
			dp[i][0] = i;
		}
		for (int i = 5; i < 5000; i++) {
			if (idx < 6 && i == coin[idx + 1]) {
				dp[i][++idx] = 1;
			} else {
				for (int j = 0; j < 7; j++) {
					dp[i][j] = dp[coin[idx]][j] + dp[i - coin[idx]][j];
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()) / 10;
			num = n / 5000;
			n %= 5000;
			
			sb.append("#").append(tc).append("\n").append(num).append(" ");
			for (int i = 6; i >= 0; i--) {
				sb.append(dp[n][i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}