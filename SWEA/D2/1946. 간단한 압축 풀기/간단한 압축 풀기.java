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
		char c;
		int k, n, cnt;
		int[][] arr;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			
			sb.append("#").append(tc).append(" ").append("\n");

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				c = st.nextToken().charAt(0);
				k = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < k; j++) {
					sb.append(c);
					cnt++;
					if (cnt == 10) {
						cnt = 0;
						sb.append("\n");
					}
				}
			}
            
            sb.append("\n");

		}

		System.out.println(sb);
	}
}
