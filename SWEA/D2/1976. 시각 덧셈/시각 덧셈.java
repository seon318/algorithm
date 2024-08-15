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
		int h1, h2, m1, m2, h, m;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			h1 = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			h2 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			h = h1 + h2;
			m = m1 + m2;
			
			if (m >= 60) {
				m -= 60;
				h++;
			}
			
			if (h > 12) {
				h -= 12;
			}
			
			sb.append("#").append(tc).append(" ").append(h).append(" ").append(m).append("\n");

		}

		System.out.println(sb);
	}
}
