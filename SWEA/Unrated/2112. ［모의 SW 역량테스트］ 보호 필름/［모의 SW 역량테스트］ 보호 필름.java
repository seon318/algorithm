import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int d, w, k, ans, x, y, cnt;
	static int[][] film;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			film = new int[d][w];
			sel = new int[d];
			for (int i = 0; i < d; i++) {
				sel[i] = -1;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#").append(tc).append(" ");
			ans = 0;
			if (check()) {
				sb.append(ans).append("\n");
				continue;
			}
			
			for (int i = 1; i <= d; i++) {
				comb(0, 0, i);
				if (ans != 0 )break;
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx, int num) {
		if (ans != 0) return;
		
		if (cnt == num) {
			if (check()) ans = num;
		}
		
		for (int i = idx; i < d; i++) {
			sel[i] = 0;
			comb(cnt + 1, i + 1, num);
			sel[i] = 1;
			comb(cnt + 1, i + 1, num);
			sel[i] = -1;
		}
	}
	
	static boolean check() {
		for (int j = 0; j < w; j++) {
			x = sel[0] == -1 ? film[0][j] : sel[0];
			y = 0;
			cnt = 1;
			for (int i = 1; i < d; i++) {
				y = sel[i] == -1 ? film[i][j] : sel[i];
				if (x == y) cnt++;
				else {
					x = y;
					cnt = 1;
				}
				if (cnt == k) break;
			}
			if (cnt < k) return false;
		}
		return true;
	}
}