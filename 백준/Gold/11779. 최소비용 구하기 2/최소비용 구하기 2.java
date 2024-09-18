import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int e, c;
		Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int v, e, c;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		int[] dist = new int[n + 1];
		int[] route = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[v].add(new Node(e, c));
		}
		
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		route[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.e == end) break;
			if (dist[now.e] < now.c) continue;
			
			for (Node next : graph[now.e]) {
				if (dist[next.e] > now.c + next.c) {
					dist[next.e] = now.c + next.c;
					pq.add(new Node(next.e, dist[next.e]));
					route[next.e] = now.e;
				}
			}
		}
		sb.append(dist[end] + " \n");
		ArrayList<Integer> order = new ArrayList<>();
		int find = end;
		while (find != 0) {
			order.add(find);
			find = route[find];
		}
		
		sb.append(order.size() + " \n");
		for (int i = order.size() - 1; i >= 0; i--) {
			sb.append(order.get(i) + " ");
		}
		System.out.println(sb);
	}
}