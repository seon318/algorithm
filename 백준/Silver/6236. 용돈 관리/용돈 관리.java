import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, left, right, ans;
	static int[] cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cost = new int[n];
		left = 0;
		right = 0;
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			left = Math.max(left, cost[i]);
			right += cost[i];
		}
		

		while (left <= right) {
			int mid = (left + right) / 2;

			if (check(mid)) {
				ans = mid;
				right = mid - 1;
			}
			else left = mid + 1;
		}
		
		System.out.println(ans);
		
	}
	
	static boolean check(int x) {
		int now = x;
		int cnt = 1;
		
		for (int i = 0; i < n; i++) {
			if (now - cost[i] < 0) {
				now = x;
				cnt++;
			}
			now -= cost[i];
		}
		if (cnt <= m) return true;
		return false;
	}
}