import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, cnt1, cnt2;
    static char[][] grid;
    static boolean[][] normal, unNormal;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        normal = new boolean[n][n];
        unNormal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!normal[i][j]) {
                    dfs(i, j, grid[i][j], normal, false);
                    cnt1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!unNormal[i][j]) {
                    dfs(i, j, grid[i][j], unNormal, true);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    static void dfs(int x, int y, char c, boolean[][] visited, boolean isColorWeak) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;

            if (isColorWeak) {
                if ((c == 'R' || c == 'G') && (grid[nx][ny] == 'R' || grid[nx][ny] == 'G')) {
                    dfs(nx, ny, c, visited, true);
                } else if (grid[nx][ny] == c) {
                    dfs(nx, ny, c, visited, true);
                }
            } else {
                if (grid[nx][ny] == c) {
                    dfs(nx, ny, c, visited, false);
                }
            }
        }
    }
}
