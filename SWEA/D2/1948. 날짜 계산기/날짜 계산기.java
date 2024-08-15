import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int m1, m2, d1, d2, ans;
		Map<Integer, Integer> days = new HashMap<>();

		days.put(1, 31);
		days.put(2, 28);
		days.put(3, 31);
		days.put(4, 30);
		days.put(5, 31);
		days.put(6, 30);
		days.put(7, 31);
		days.put(8, 31);
		days.put(9, 30);
		days.put(10, 31);
		days.put(11, 30);
		days.put(12, 31);

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			m1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());
			ans = 0;
			
			if (d1 < d2) ans += d2 - d1 + 1;
			else ans = days.get(m1++) - d1 + 1 + d2;
			
			while (m1 < m2) {
				ans += days.get(m1++);
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
