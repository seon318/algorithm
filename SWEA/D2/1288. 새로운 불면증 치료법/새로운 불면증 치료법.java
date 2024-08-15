import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n, r;
		String x;
		boolean[] num;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			num = new boolean[10];
			r = 0;
			outer: while (true) {
				x = (n * ++r) + "";
				for (int i = 0; i < x.length(); i++) {
					num[x.charAt(i)-'0'] = true;
				}
				
				for (int i = 0; i < 10; i++) {
					if (num[i] != true) continue outer;
				}
				
				break;
			}
			
			sb.append("#").append(tc).append(" ").append(n * r).append("\n");
		}
		
		System.out.println(sb);
	}
}
