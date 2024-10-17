import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static char[][] matrix;
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {1, -1, 1, -1, 0, 0, -1, 1};
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		String input;
		matrix = new char[n][m];
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				perm(1, i, j, new StringBuilder().append(matrix[i][j]));
			}
		}
		
		for (int i = 0; i < k; i++) {
			input = br.readLine();
			if (!map.containsKey(input)) sb.append(0).append("\n");
			else sb.append(map.get(input)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void perm(int cnt, int x, int y, StringBuilder sb) {
		if (map.containsKey(sb.toString())) map.put(sb.toString(), map.get(sb.toString()) + 1);
		else map.put(sb.toString(), 1);
		if (cnt == 5) return;
		
		for (int d = 0; d < 8; d++) {
			int nx = (x + dx[d] + n) % n;
			int ny = (y + dy[d] + m) % m;
			perm(cnt + 1, nx, ny, new StringBuilder(sb).append(matrix[nx][ny]));
		}
	}
}