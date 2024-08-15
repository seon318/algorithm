import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int p, q, r, s, w, a, b;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			a = p * w;
			b = q + (w > r ? (w - r) * s : 0);
			
			sb.append("#").append(tc).append(" ").append(Math.min(a, b)).append("\n");
		}
		
		System.out.println(sb);
	}
}
