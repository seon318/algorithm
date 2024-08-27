import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, l, ans;
	static int[][] ingredients;
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			ingredients = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			comb(0, 0, 0);
						
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void comb(int score, int sum, int idx) {
		for (int i = idx; i < n; i++) {
			if (sum + ingredients[i][1] > l) {
				continue;
			}
			score += ingredients[i][0];
			sum += ingredients[i][1];
			ans = Math.max(score, ans);
			comb(score, sum, i + 1);
			score -= ingredients[i][0];
			sum -= ingredients[i][1];
		}
	}
}