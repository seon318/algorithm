import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] impt = new int[k+1];
		int[] time = new int[k+1];
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			impt[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[k+1][n+1];
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (time[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]] + impt[i]);
			}
		}
		
		System.out.println(dp[k][n]);
    }
	
	
}