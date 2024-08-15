import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n, ans;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			if (n % 2 == 0) ans = (n / 2) * -1;
			else ans = ((n-1) / 2) * -1 + n;
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
