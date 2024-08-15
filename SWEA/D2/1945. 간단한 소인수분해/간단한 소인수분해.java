import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n, x;
		int[] arr = {2, 3, 5, 7, 11};
		int[] ans = new int[5];
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 5; i++) {
				x = 0;
				while (n > 1 && n % arr[i] == 0) {
					x++;
					n /= arr[i];
				}
				ans[i] = x;
			}
						
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 5; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
