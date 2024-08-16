import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int[] popItem;
        int[][] map;
        boolean[] now;
        boolean[][] visited;
        int r, c, l, ans;

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            ans = 0;  // 테스트 케이스마다 초기화 필요

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { r, c, 1 });
            visited[r][c] = true; // 시작점 방문 처리

            while (!queue.isEmpty()) {
                popItem = queue.poll();
                int curX = popItem[0];
                int curY = popItem[1];
                int time = popItem[2];

                if (time == l) continue;

                now = getPipe(map[curX][curY]);

                for (int d = 0; d < 4; d++) {
                    if (now[d]) {
                        int nx = curX + dx[d];
                        int ny = curY + dy[d];

                        if (isValid(nx, ny) && !visited[nx][ny] && getPipe(map[nx][ny])[(d + 2) % 4]) {
                            queue.add(new int[] { nx, ny, time + 1 });
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j])
                        ans++;
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static boolean[] getPipe(int pipe) {
        switch (pipe) {
            case 1: return new boolean[] { true, true, true, true };
            case 2: return new boolean[] { true, false, true, false };
            case 3: return new boolean[] { false, true, false, true };
            case 4: return new boolean[] { true, true, false, false };
            case 5: return new boolean[] { false, true, true, false };
            case 6: return new boolean[] { false, false, true, true };
            case 7: return new boolean[] { true, false, false, true };
            default: return new boolean[] { false, false, false, false };
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
