import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static int n, score, startX, startY, nx, ny, now, ans;
    static int[][] board;
    static List<int[]> holes;
    // 상하좌우 이동
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    // 기존 이동방향이 상하좌우일 때 각각 벽(0번), 1~5번 블록 만났을 때의 이동방향
    static int[][] dir = { { 1, 1, 3, 2, 1, 1 }, { 0, 3, 0, 0, 2, 0 }, { 3, 0, 1, 3, 3, 3 }, { 2, 2, 2, 1, 0, 2 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();

            board = new int[n][n];
            holes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] >= 6) {
                        holes.add(new int[] { board[i][j], i, j });
                    }
                }
            }

            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0)
                        continue;
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, playGame(i, j, d));
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int playGame(int x, int y, int d) {
        startX = x;
        startY = y;
        score = 0;

        while (true) {

            // 현재 방향으로 이동
            nx = x + dx[d];
            ny = y + dy[d];

            // 시작점으로 돌아오면 게임 종료
            if (nx == startX && ny == startY) break;
            
            // 벽에 부딪혔을 때
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                score++;
                d = dir[d][0]; // 반대 방향 전환
                x = nx;
                y = ny;
                continue;
            }

            now = board[nx][ny];
            switch (now) {
                // 블랙홀
                case -1:
                    return score;
                // 빈 공간
                case 0:
                    x = nx;
                    y = ny;
                    break;
                // 블록
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    score++;
                    d = dir[d][now];
                    x = nx;
                    y = ny;
                    break;
                // 웜홀
                default:
                    for (int[] hole : holes) {
                        if (hole[0] == now && (hole[1] != nx || hole[2] != ny)) {
                            x = hole[1];
                            y = hole[2];
                            break;
                        }
                    }
                    break;
            }
            
        }

        return score;
    }
}
