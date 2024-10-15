import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int c;
		int start;
		public Node(int v, int c, int start) {
			super();
			this.v = v;
			this.c = c;
			this.start = start;
		}
		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
		@Override
		public String toString() {
			return "Node [v=" + v + ", c=" + c + ", start=" + start + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] list = new ArrayList[n+1];
		int[][] time = new int[n+1][n+1];
		int[][] num = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			Arrays.fill(time[i], n * 1000);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c, b));
			list[b].add(new Node(a, c, a));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			pq.add(new Node(i, 0, 0));
			while (!pq.isEmpty()) {
				Node poll = pq.poll();
				for (Node node : list[poll.v]) {
					int cost = poll.c + node.c;
					if (time[i][node.v] > cost) {
						time[i][node.v] = cost;
						num[i][node.v] = poll.start == 0 ? node.v : poll.start;
						pq.add(new Node(node.v, cost, num[i][node.v]));
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) sb.append("- ");
				else sb.append(num[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}