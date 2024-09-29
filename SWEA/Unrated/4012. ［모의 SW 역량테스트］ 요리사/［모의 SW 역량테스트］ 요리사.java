import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, a, b, sum1, sum2, ans;
	static boolean[] sel;
	static int[][] arr;
	static int[] sel1, sel2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			sel = new boolean[n];
			sel1 = new int[n/2];
			sel2 = new int[n/2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j =0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			comb(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == n / 2) {
			a = 0;
			b = 0;
			for (int i = 0; i < n; i++) {
				if (sel[i]) sel1[a++] = i;
				else sel2[b++] = i;
			}
			sum1 = 0;
			sum2 = 0;
			for (int i = 0; i < n / 2 - 1; i++) {
				for (int j = i + 1; j < n / 2; j++) {
					sum1 += arr[sel1[i]][sel1[j]];
					sum1 += arr[sel1[j]][sel1[i]];
					sum2 += arr[sel2[i]][sel2[j]];
					sum2 += arr[sel2[j]][sel2[i]];
				}
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;
		}
		
		for (int i = idx; i < n; i++) {
			sel[i] = true;
			comb(cnt + 1, i + 1);
			sel[i] = false;
		}
	}
}