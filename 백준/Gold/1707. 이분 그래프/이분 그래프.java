import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int[] grouped;
	static boolean ans;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= k; tc++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[v+1];
			visited = new boolean[v+1];
			grouped = new int[v+1];
			ans = true;
			
			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			for (int i = 1; i <= v; i++) {
				if (!visited[i]) {
					if (ans) bfs(i);
					else break;
				}
			}
			
			sb.append(ans ? "YES" : "NO").append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			
			for (int i : graph[x] ) {
				if (visited[i]) {
					if (grouped[i] == grouped[x]) {
						ans = false;
						return;
					}
				} else {
					visited[i] = true;
					grouped[i] = 1 - grouped[x];
					queue.add(i);
				}
			}
		}
	}
}
