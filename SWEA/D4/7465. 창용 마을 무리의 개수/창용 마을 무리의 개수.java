import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, a, b, cnt;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = findSet(Integer.parseInt(st.nextToken()));
				b = findSet(Integer.parseInt(st.nextToken()));
				if (a != b) arr[b] = a;
			}
			
			cnt = 0;
			visited = new boolean[n + 1];
			for (int i = 1; i  <= n; i++) {
				if (!visited[findSet(i)]) {
					cnt++;
					visited[findSet(i)] = true;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static int findSet(int x) {
		if (arr[x] != x) {
			arr[x] = findSet(arr[x]);
		}
		return arr[x];
	}
}
