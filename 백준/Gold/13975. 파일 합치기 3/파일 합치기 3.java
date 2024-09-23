import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static long sum, now;
	static PriorityQueue<Long> pq = new PriorityQueue<>();;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			k = Integer.parseInt(br.readLine());
			pq.clear();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			sum = 0;
			while (!pq.isEmpty()) {
				now = pq.poll() + pq.poll();
				sum += now;
				if (!pq.isEmpty()) pq.add(now);
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}