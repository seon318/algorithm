import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, h;
	static int[] height, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			height = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			h = getHeight();
			tree = new int[h];
			init(1, 1, n);
			
			sb.append(getMax(1, n)).append("\n");
		}

		System.out.println(sb);

	}
	
	static int getHeight() {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int) Math.pow(2, h+1);
	}
	
	static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}
		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid + 1, end);

		if (height[tree[node * 2]] <= height[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}
	}
	
	static int query(int start, int end, int node, int from, int to) {
		if (from > end || to < start) return -1;
		if (from <= start && to >= end) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		int m1 = query(start, mid, node*2, from, to);
		int m2 = query(mid+1, end, node*2+1, from, to);
		if (m1 == -1) return m2;
		if (m2 == -1) return m1;
		return height[m1] <= height[m2] ? m1 : m2;

	}
	
	
	static long getMax(int start, int end) {
		int m = query(1, n, 1, start, end);
		long area = (end - start + 1) * (long) height[m];
		
		if (start <= m-1) {
			long tmp = getMax(start, m-1);
			area = Math.max(area, tmp);
		}
		
		if (m+1 <= end) {
			long tmp = getMax(m+1, end);
			area = Math.max(area, tmp);
		}
		
		return area;
	}
}