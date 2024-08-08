import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int x, y, nx, ny, tmp;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					paper[x + i][y + j] = 1;
				}
			}
		}
		int ans = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {
					tmp = 0;
					for (int k = 0; k < 4; k++) {
						nx = i + dx[k];
						ny = j + dy[k];
						if (0 <= nx && nx < 100 && 0 <= ny && ny < 100) {
							if (paper[nx][ny] == 1)
								tmp++;
						}
					}
					if (tmp == 3)
						ans += 1;
					else if (tmp == 2)
						ans += 2;
				}
			}
		}
		System.out.println(ans);
	}
}
