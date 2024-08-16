import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n, timeO, timeB, idxO, idxB, x;
		int[][] arr;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n][2];
			timeO = 0;
			timeB = 0;
			idxO = 1;
			idxB = 1;
			
			for (int i = 0; i < n; i++) {
				arr[i][0] = st.nextToken().equals("B") ? 1 : 0;
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			for (int i = 0; i < n; i++) {
				x = arr[i][1];
				if (arr[i][0] == 1) {
					timeB += Math.abs(x - idxB) + 1;
					if (i > 0 && arr[i - 1][0] == 0) {
						timeB = Math.max(timeB, timeO + 1);
					}
					idxB = x;
				} else {
					timeO += Math.abs(x - idxO) + 1;
					if (i > 0 && arr[i - 1][0] == 1) {
						timeO = Math.max(timeB + 1, timeO);
					}
					idxO = x;
				}
				
					
			}
			
			sb.append('#').append(tc).append(' ').append(Math.max(timeO, timeB)).append('\n');
		}
		System.out.println(sb);
	}
}