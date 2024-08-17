import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, max, startX, startY;
    static int[][] dessert;
    static int[] dx = { 1, 1, -1, -1 };
    static int[] dy = { 1, -1, -1, 1 };
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            dessert = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    dessert[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited = new boolean[101];
                    startX = i;
                    startY = j;
                    visited[dessert[i][j]] = true;
                    dfs(i, j, 1, 0);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int count, int dir) {
        for (int i = dir; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx == startX && ny == startY && count > 2) {
                max = Math.max(max, count);
                return;
            }

            if (isValid(nx, ny)) {
                visited[dessert[nx][ny]] = true;
                dfs(nx, ny, count + 1, i);
                visited[dessert[nx][ny]] = false;
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && !visited[dessert[x][y]];
    }
}
