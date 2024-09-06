import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, b, min, ans;
	static int[] height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			height = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			comb(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(min - b).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx, int sum) {
		if (sum >= min) return;
		
		if (sum >= b) {
			min = Math.min(min, sum);
			return;
		}
		
		if (cnt == n) {
			return;
		}
		
		for (int i = idx; i < n; i++) {
			comb(cnt + 1, i + 1, sum + height[i]);
		}
	}
}