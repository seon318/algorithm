import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] cnt;
		int n;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			cnt = new int[8];
			
			for (int i = 0; i < 8; i++) {
				cnt[i] += n / money[i];
				n = n % money[i];
			}
			
			sb.append("#").append(tc).append(" ").append("\n");
			for (int i = 0; i < 8; i++) {
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}
}
