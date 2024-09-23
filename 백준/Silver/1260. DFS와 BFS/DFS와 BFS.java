import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!adjList[a].contains(b)) adjList[a].add(b);
			if (!adjList[b].contains(a)) adjList[b].add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(adjList[i]);
		}
		
		visited = new boolean[n + 1];
		visited[v] = true;
		dfs(v);
		
		sb.append("\n");
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited = new boolean[n + 1];
		visited[v] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now + " ");
			for (int x : adjList[now]) {
				if (visited[x]) continue;
				visited[x] = true;
				queue.add(x);
			}
		}
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		sb.append(v + " ");
		for (int x : adjList[v]) {
			if (visited[x]) continue;
			visited[x] = true;
			dfs(x);
		}
	}
}