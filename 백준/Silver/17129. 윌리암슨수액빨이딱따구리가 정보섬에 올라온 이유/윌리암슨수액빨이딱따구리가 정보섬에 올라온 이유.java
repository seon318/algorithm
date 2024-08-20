import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new LinkedList<>();
		int[][] arr = new int[n][m];
		int[][] dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
				if (arr[i][j] == 2) {
					queue.add(new int[] {i, j, 1});
				}
			}
		}
				
		int ans = -1;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		outer : while (!queue.isEmpty()) {
			int[] popItem = queue.poll();
			int x = popItem[0];
			int y = popItem[1];
			int z = popItem[2];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] != 1 && dist[nx][ny] == 0) {
					dist[nx][ny] = z;
					if (arr[nx][ny] > 2) {
						ans = z;
						break outer;
					}
					queue.add(new int[] {nx, ny, z + 1});
				}
			}
			
		}
		
		sb.append(ans == -1 ? "NIE" : "TAK\n"+ans);
		System.out.println(sb);
			}
}
