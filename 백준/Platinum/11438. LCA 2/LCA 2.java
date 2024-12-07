import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		boolean[] isVisited = new boolean[N+1];
		int[] depth = new int[N+1];
		int k = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int[][] parent = new int[N+1][k];
		
		DFS(graph, isVisited, depth, parent, 0, 1);
		set_spaTable(parent, N, k);
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			sb.append(LCA(n1, n2, parent, depth, k)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int LCA(int n1, int n2, int[][] parent, int[] depth, int k) {
		if (depth[n1] > depth[n2]) {
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		
		for (int i = k-1; i >=0; i--) {
			if (depth[n2] - depth[n1] >= Math.pow(2, i)) {
				n2 = parent[n2][i];
			}
		}
		
		if (n1 == n2) return n1;
		
		for (int i = k-1; i >= 0; i--) {
			if (parent[n1][i] != parent[n2][i]) {
				n1 = parent[n1][i];
				n2 = parent[n2][i];
			}
		}
		
		return parent[n1][0];
	}
	
	static void DFS(List<List<Integer>> graph, boolean[] isVisited, int[] depth, int[][] parent, int curDepth, int node) {
		isVisited[node] = true;
		depth[node] = curDepth;
		
		for (int childNode : graph.get(node)) {
			if (!isVisited[childNode]) {
				parent[childNode][0] = node;
				DFS(graph, isVisited, depth, parent, curDepth+1, childNode);
			}
		}
	}
	
	static void set_spaTable(int[][] parent, int N, int k) {
		for (int i = 1; i < k; i++) {
			for (int node = 1; node <= N; node++) {
				parent[node][i] = parent[parent[node][i-1]][i-1];
			}
		}
	}
}