import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, x, height, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		for (int i = 0; i < n; i++) {
			checkRow(i);
			checkCol(i);
		}
		System.out.println(ans);

	}

	static void checkRow(int i) {
		visited = new boolean[n];
        height = map[i][0];

        for (int j = 1; j < n; j++) {
            if (map[i][j] == height) continue;

            if (Math.abs(map[i][j] - height) > 1) return;

            if (map[i][j] > height) {
                for (int k = 1; k <= x; k++) {
                    if (j - k < 0 || map[i][j - k] != height || visited[j - k]) return;
                    visited[j - k] = true;
                }
                height = map[i][j];
            } else {
                height = map[i][j];
                for (int k = 0; k < x; k++) {
                    if (j + k >= n || map[i][j + k] != height || visited[j + k]) return;
                    visited[j + k] = true;
                }
                j += x - 1;
            }
        }
        ans++;
	}

	static void checkCol(int j) {
		 visited = new boolean[n];
	        height = map[0][j];

	        for (int i = 1; i < n; i++) {
	            if (map[i][j] == height) continue;

	            if (Math.abs(map[i][j] - height) > 1) return;

	            if (map[i][j] > height) {
	                for (int k = 1; k <= x; k++) {
	                    if (i - k < 0 || map[i - k][j] != height || visited[i - k]) return;
	                    visited[i - k] = true;
	                }
	                height = map[i][j];
	            } else {
	                height = map[i][j];
	                for (int k = 0; k < x; k++) {
	                    if (i + k >= n || map[i + k][j] != height || visited[i + k]) return;
	                    visited[i + k] = true;
	                }
	                i += x - 1;
	            }
	        }
	        ans++;
	    }
	}