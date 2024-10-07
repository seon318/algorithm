import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});
		
		int a, b, c;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist, 50000000);
		
		pq.add(new int[] {0, 0});

		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			if (item[0] == n - 1) {
				System.out.println(item[1]);
				return;
			}
			if (dist[item[0]] < item[1]) continue;
			ArrayList<int[]> now = list[item[0]];
			for (int i = 0; i < now.size(); i++) {
				int cost = now.get(i)[1] + item[1];
				if (cost < dist[now.get(i)[0]]) {
					dist[now.get(i)[0]] = cost;
					pq.add(new int[] {now.get(i)[0], cost});
				}
			}
		}
	}
}