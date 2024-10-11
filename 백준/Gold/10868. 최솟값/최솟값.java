import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] num, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n+1];
		tree = new int[getTreeSize()];
		for (int i = 1; i <= n; i++) num[i] = Integer.parseInt(br.readLine());
		init(1, n, 1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			System.out.println(getMin(1, n, 1, from, to));
		}
	}
	
	static int getTreeSize(){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        return (int)Math.pow(2,h+1);
    }
	
	static int init(int start, int end, int node) {
		if (start == end) return tree[node] = num[start];
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
	}
	
	static int getMin(int start, int end, int node, int from, int to) {
		if (from > end || to < start) return Integer.MAX_VALUE;
		if (from <= start && to >= end) return tree[node];
		int mid = (start + end) / 2;
		return Math.min(getMin(start, mid, node*2, from, to), getMin(mid+1, end, node*2+1, from, to));
	}
}