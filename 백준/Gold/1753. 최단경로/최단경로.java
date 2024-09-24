import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		

		
		ArrayList<int[]>[] adjList = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			adjList[i] = new ArrayList<>();
		}
		int a, b, c;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			adjList[a].add(new int[] {b, c});
		}

		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});
		pq.add(new int[] {k, 0});
		
		boolean[] visited = new boolean[v + 1];
		
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			a = item[0];
			b = item[1];
			if (visited[a]) continue;
			visited[a] = true;
			for (int[] x : adjList[a]) {
				dist[x[0]] = Math.min(dist[x[0]], dist[a] + x[1]);
				pq.add(new int[] {x[0], dist[x[0]]});
			}
		}
		
		for (int i = 1; i <= v; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}

}
