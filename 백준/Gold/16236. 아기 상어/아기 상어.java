import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> que;
        boolean[][] visited;
        int nx, ny;
        int n = Integer.parseInt(br.readLine());
        int[][] space = new int[n][n];
        int[] shark = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    shark = new int[] { i, j, 0 };
                    space[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eatCnt = 0;
        int time = 0;

        while (true) {
            que = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            });
            visited = new boolean[n][n];

            que.add(new int[] { shark[0], shark[1], 0 });
            visited[shark[0]][shark[1]] = true;

            boolean found = false;
            int[] target = null;

            while (!que.isEmpty()) {
                int[] current = que.poll();
                int y = current[0];
                int x = current[1];
                int dist = current[2];

                // 먹이 발견 시
                if (space[y][x] != 0 && space[y][x] < size) {
                    target = new int[] { y, x, dist };
                    found = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    ny = y + dy[k];
                    nx = x + dx[k];

                    if (0 <= nx && 0 <= ny && nx < n && ny < n && !visited[ny][nx] && space[ny][nx] <= size) {
                        que.add(new int[] { ny, nx, dist + 1 });
                        visited[ny][nx] = true;
                    }
                }
            }

            if (!found) {
                break;
            }

            // 먹이 먹기
            space[target[0]][target[1]] = 0;
            eatCnt++;
            time += target[2];
            shark[0] = target[0];
            shark[1] = target[1];

            if (size == eatCnt) {
                size++;
                eatCnt = 0;
            }
        }

        System.out.println(time);
    }
}
