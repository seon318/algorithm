import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] c;
	static PriorityQueue<Jewel> jewels = new PriorityQueue<>();
	static PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> {
		return o2.v - o1.v;
	});
	
	static class Jewel implements Comparable<Jewel>{
		int m, v;

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			if (this.m != o.m) return this.m - o.m;
			return o.v - this.v;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		c = new int[k];
		for (int i = 0; i < k; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(c);
		
		long ans = 0;
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			while (!jewels.isEmpty() && jewels.peek().m <= c[i]) {
				pq.add(jewels.poll());
			}
			if (!pq.isEmpty()) ans += pq.poll().v;
		}
		
		System.out.println(ans);
    }

}