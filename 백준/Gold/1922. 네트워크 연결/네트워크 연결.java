import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a, b, c;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] =i;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a, b, c});
		}
		
		int pick = 0;
		int ans = 0;
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			a = findP(item[0]);
			b = findP(item[1]);
			c = item[2];
			if (a != b) {
				p[a] = b;
				ans += c;
				pick++;
			}
			if (pick == n - 1) break;
		}
		
		System.out.println(ans);
	}
	
	static int findP(int x) {
		if (x != p[x]) p[x] = findP(p[x]);
		return p[x];
	}
}