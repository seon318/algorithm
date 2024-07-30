import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] dp = new int[n+1];
		int day = 0;
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=i+arr[i][0]; j<n+1; j++) {
				if (dp[j] < dp[i] + arr[i][1])
					dp[j] = dp[i] + arr[i][1];
 			}
		}
		System.out.println(dp[dp.length-1]);
	}
}
