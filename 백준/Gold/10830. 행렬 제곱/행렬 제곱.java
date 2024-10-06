import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long b;
	static int[][] matrix, ans;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		matrix = new int[n][n];
		ans = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		dp = new int[43][][];
		dp[0] = matrix;
		for (int i = 1; i < 43; i++) {
			dp[i] = pow(dp[i-1], dp[i-1]);
		}
		StringBuilder binary = new StringBuilder();
		binary.append(Long.toBinaryString(b)).reverse();
		
		ans = dp[binary.length() - 1];
		
		for (int i = 0; i < binary.length() - 1; i++) {
			if (binary.charAt(i) == '1')
				ans = pow(ans, dp[i]);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int[][] pow(int[][] arr1, int[][] arr2) {
		
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
				result[i][j] %= 1000;
			}
		}
						
		return result;
	}
}