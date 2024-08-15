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
		int n, command, x, s, d;

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			s = 0;
			d = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				command = Integer.parseInt(st.nextToken());
				if (command != 0) {
					x = Integer.parseInt(st.nextToken());

					if (command == 1)
						s += x;
					else
						s = s > x ? s - x : 0;
				}
				d += s;
			}

			sb.append("#").append(tc).append(" ").append(d).append("\n");
		}

		System.out.println(sb);
	}
}
