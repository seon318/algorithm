import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int a, b, c;

		Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}

	static int a, b, c, n, m, pa, pb;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<>();

		p = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a, b, c));
		}

		int pick = 0;
		int ans = 0;
		int last = 0;
		Node node;
		while (!pq.isEmpty()) {
			node = pq.poll();
			pa = findSet(node.a);
			pb = findSet(node.b);
			if (pa != pb) {
				p[pa] = pb;
				pick++;
				ans += node.c;
				last = node.c;
			}
			if (pick == n - 1)
				break;
		}
		System.out.println(ans - last);
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}