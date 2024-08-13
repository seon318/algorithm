import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n, m, k;
    static int[][][] arr;
    static List<Shark> sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n][2];
        sharks = new ArrayList<>();

        // 격자 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j][0] = Integer.parseInt(st.nextToken());
                if (arr[i][j][0] != 0) {
                    arr[i][j][1] = k; // 냄새 잔여 시간
                    sharks.add(new Shark(arr[i][j][0], i, j)); // 상어 객체 추가
                } else {
                    arr[i][j][1] = 0;
                }
            }
        }

        // 작은 번호부터 상어 정렬
        sharks.sort((o1, o2) -> o1.id - o2.id);

        // 상어 방향 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sharks.get(i).d = Integer.parseInt(st.nextToken()) - 1;
        }

        // 상어 방향 우선순위 입력
        for (int i = 0; i < m; i++) {
            int[][] dir = new int[4][4];
            for (int r = 0; r < 4; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 4; c++) {
                    dir[r][c] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
            sharks.get(i).dir = dir;
        }
        
        int time = 0;

        // 상어가 1마리 남을 때까지 반복
        while (sharks.size() > 1 && time <= 1000) {
            time++;

            int[][] sharkMap = new int[n][n];

            // 상어 이동시키기
            for (int i = 0; i < sharks.size(); i++) {
                Shark shark = sharks.get(i);
                boolean moved = false;

                // 1순위: 냄새 없는 칸
                for (int j = 0; j < 4; j++) {
                    int newDir = shark.dir[shark.d][j];
                    int nx = shark.x + dx[newDir];
                    int ny = shark.y + dy[newDir];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny][0] == 0) {
                        shark.x = nx;
                        shark.y = ny;
                        shark.d = newDir;
                        moved = true;
                        break;
                    }
                }

                // 2순위: 자신의 냄새가 있는 칸
                if (!moved) {
                    for (int j = 0; j < 4; j++) {
                        int newDir = shark.dir[shark.d][j];
                        int nx = shark.x + dx[newDir];
                        int ny = shark.y + dy[newDir];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny][0] == shark.id) {
                            shark.x = nx;
                            shark.y = ny;
                            shark.d = newDir;
                            break;
                        }
                    }
                }

                // 이동한 위치에 다른 상어가 있는지 확인
                if (sharkMap[shark.x][shark.y] == 0) {
                    sharkMap[shark.x][shark.y] = shark.id;
                } else {
                    if (sharkMap[shark.x][shark.y] < shark.id) {
                        sharks.remove(i--);
                    } else {
                        sharks.removeIf(s -> s.id == sharkMap[shark.x][shark.y]);
                        sharkMap[shark.x][shark.y] = shark.id;
                    }
                }
                
            }

            // 냄새 시간 1 줄이고 0이 되면 냄새 없애기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j][1] > 0) {
                        arr[i][j][1]--;
                        if (arr[i][j][1] == 0) {
                            arr[i][j][0] = 0;
                        }
                    }
                }
            }

            // 상어가 있는 칸에 냄새 뿌리기
            for (Shark shark : sharks) {
                arr[shark.x][shark.y][0] = shark.id;
                arr[shark.x][shark.y][1] = k;
            }
            
        }

        if (time > 1000) time = -1;

        bw.write(time + "\n");
        bw.flush();
    }

    // 상어 클래스
    static class Shark {
        int id, x, y, d;
        int[][] dir;

        Shark(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
}
