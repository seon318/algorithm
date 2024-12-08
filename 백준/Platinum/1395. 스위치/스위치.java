import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] tree;
	static boolean[] lazy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		tree = new int[1 << h + 1];
		lazy = new boolean[1 << h + 1];
		
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if (o == 0) update(1, 1, n, s, t);
			else sb.append(query(1, 1, n, s, t)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int query(int node, int start, int end, int left, int right) {
		lazyUpdate(node, start, end);
		if (start > right || end < left) return 0;

		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) >> 1;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, int left, int right) {
		lazyUpdate(node, start, end);
		if (start > right || end < left) return;
		
		if (left <= start && end <= right) {
			tree[node] = (end - start + 1) - tree[node];
			if (start != end) {
				lazy[node * 2] = !lazy[node * 2];
				lazy[node * 2 + 1] = !lazy[node * 2 + 1];
			}
			return;
		}
		
		int mid = (start + end) >> 1;
		update(node * 2, start, mid, left, right);
		update(node * 2 + 1, mid + 1, end, left, right);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	private static void lazyUpdate(int node, int start, int end) {
		if (lazy[node]) {
			tree[node] = (end - start + 1) - tree[node];
			if (start != end) {
				lazy[node * 2] = !lazy[node * 2];
				lazy[node * 2 + 1] = !lazy[node * 2 + 1];
			}
			lazy[node] = false;
		}
	}
}