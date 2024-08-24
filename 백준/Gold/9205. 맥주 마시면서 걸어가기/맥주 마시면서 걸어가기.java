import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] list;
	static boolean isPossible;
	static boolean[] visited;
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new int[n + 2][2];
			graph = new boolean[n + 2][n + 2];
			visited = new boolean[n + 2];
			isPossible = false;

			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if (Math.abs(list[i][0] - list[j][0]) + Math.abs(list[i][1] - list[j][1]) <= 1000) {
						graph[i][j] = true;
						graph[j][i] = true;
					}
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			visited[0] = true;

			outer : while (!q.isEmpty()) {
				int p = q.poll();

				for (int i = 0; i < n + 2; i++) {
					if (graph[p][i] && !visited[i]) {
						if (i == n + 1) {
							isPossible = true;
							break outer;
						}
						visited[i] = true;
						q.add(i);
					}
				}
			}
			
			sb.append(isPossible ? "happy" : "sad").append('\n');

		}

		System.out.print(sb);
	}
}
