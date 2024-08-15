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
		int n;
		int[][] pascal;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			pascal = new int[n][n];
			
			pascal[0][0] = 1;
			for (int i = 1; i < n; i++) {
				pascal[i][0] = 1;
				pascal[i][i] = 1;
				for (int j = 1; j < i; j++) {
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
			
			sb.append("#").append(tc).append(" ").append("\n");
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (pascal[i][j] == 0) break;
					sb.append(pascal[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}
