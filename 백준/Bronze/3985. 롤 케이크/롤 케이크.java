import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] cake = new int[l+1];
		
		int p, k, num;
		int[] expect = new int[2];
		int[] actual = new int[2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if (expect[1] < k - p) {
				expect[0] = i;
				expect[1] = k - p;
			}
			
			num = 0;
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j]++;
					num++;
				}
			}
			
			if (actual[1] < num) {
				actual[0] = i;
				actual[1] = num;
			}
		}
		System.out.println(expect[0]);
		System.out.println(actual[0]);
	}
}