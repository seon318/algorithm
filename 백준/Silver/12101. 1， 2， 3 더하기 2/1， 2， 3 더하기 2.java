import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 3; i++) perm(1, i, new StringBuilder().append(i));
		if (order < k) System.out.println(-1);
	}

	private static void perm(int cnt, int sum, StringBuilder sb) {
		if (sum > n) return;
		if (sum == n) {
			order++;
			if (order == k) System.out.println(sb);
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			perm(cnt + 1, sum + i, new StringBuilder().append(sb).append("+").append(i));
		}
	}
}