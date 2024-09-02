import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] sel, num;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(num);

		sel = new int[m];
		
		comb(0, 0);
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < n; i++) {
			sel[cnt] = num[i];
			comb(cnt + 1, i + 1);
		}
	}
}
