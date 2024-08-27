import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//동서북남 
		int[] dr = {0, 0, 0, -1, 1};
		int[] dc = {0, 1, -1, 0, 0};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int tmp, nr, nc;
		
		int[][] matrix = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dice = {1, 3, 4, 2, 5, 6};
		int[] value = new int[7];
 		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int d = Integer.parseInt(st.nextToken());

			nr = r + dr[d];
			nc = c + dc[d];
			
			if (0 > nr || nr >= n || 0 > nc || nc >= m) continue;
			
			r = nr;
			c = nc;
			
			tmp = dice[d];
			dice[d] = dice[0];
			dice[0] = 7 - tmp;
			dice[d + (d % 2 == 0 ? -1 : 1)] = dice[5];
			dice[5] = tmp;

									
			if (matrix[r][c] == 0) {
				matrix[r][c] = value[dice[0]];
			} else {
				value[dice[0]] = matrix[r][c];
				matrix[r][c] = 0;
			}
			
 			sb.append(value[dice[5]]).append("\n");
		}
		
		System.out.print(sb);
	}
}