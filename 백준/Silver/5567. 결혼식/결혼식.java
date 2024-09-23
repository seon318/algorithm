import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n + 1];
		List<Integer>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}
	
		for (int x : adjList[1]) {
			visited[x] = true;
			for (int y : adjList[x]) {
				visited[y] = true;
			}
		}
		
		int cnt = 0;
		for (boolean visit : visited) {
			if (visit) cnt++;
		}
		
		System.out.println(cnt == 0? 0 : cnt - 1);
	}
}