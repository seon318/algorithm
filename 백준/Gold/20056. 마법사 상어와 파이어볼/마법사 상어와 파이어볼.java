import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());

        List<Fireball> fireballs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine(), " ");

            int ri = Integer.parseInt(stz.nextToken()) - 1;
            int ci = Integer.parseInt(stz.nextToken()) - 1;
            int mi = Integer.parseInt(stz.nextToken());
            int si = Integer.parseInt(stz.nextToken());
            int di = Integer.parseInt(stz.nextToken());

            fireballs.add(new Fireball(ri, ci, mi, si, di));
        }

        while (k-- > 0) {
            int ballCount = fireballs.size();

            int[][][] map = new int[n][n][ballCount];

            moveTheFireball(fireballs, ballCount, map);

            fireballs = splitTheFireball(fireballs, ballCount, map);
        }

        for (Fireball fireball : fireballs) {
            answer += fireball.m;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void moveTheFireball(List<Fireball> fireballs, int ballCount, int[][][] map) {
        for (int i = 0; i < fireballs.size(); i++) {
            Fireball fireball = fireballs.get(i);

            int sx = dx[fireball.d] * fireball.s;
            int sy = dy[fireball.d] * fireball.s;

            int nx = adjustCoordinate(fireball.r, sx);
            int ny = adjustCoordinate(fireball.c, sy);

            for (int j = 0; j < ballCount; j++) {
                if (map[nx][ny][j] == 0) {
                    map[nx][ny][j] = i + 1;
                    break;
                }
            }

            fireball.r = nx;
            fireball.c = ny;
        }
    }

    private static int adjustCoordinate(int coordinate, int d) {
        if (d < 0) d = (Math.abs(d) % n) * -1;
        else d = d % n;

        coordinate += d;

        if (coordinate >= 0 && coordinate < n) {
            return coordinate;
        } else if (coordinate >= n) {
            return coordinate - n;
        } else { 
            return n + coordinate;
        }
    }

    private static List<Fireball> splitTheFireball(List<Fireball> fireballs, int ballCount, int[][][] map) {
        List<Fireball> move = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ballCount > 1 && map[i][j][1] > 0) {
                    int tm = 0;
                    int ts = 0;
                    int firstDirection = fireballs.get(map[i][j][0] - 1).d;
                    boolean isAllEvenOrOddDirection = true;
                    int cnt = 0;

                    for (int t = 0; t < ballCount; t++) {
                        if (map[i][j][t] == 0) break;

                        Fireball fireball = fireballs.get(map[i][j][t] - 1);
                        tm += fireball.m; 
                        ts += fireball.s; 

                        if (isAllEvenOrOddDirection) {
                            if (firstDirection % 2 != fireball.d % 2) {
                                isAllEvenOrOddDirection = false;
                            }
                        }
                        cnt++;
                    }

                    for (int o = 0; o < 4; o++) {
                        int pm = tm / 5;
                        int ps = ts / cnt;

                        if (pm == 0) break;

                        if (isAllEvenOrOddDirection) {
                            move.add(new Fireball(i, j, pm, ps, o * 2));
                        } else {
                            move.add(new Fireball(i, j, pm, ps, (o * 2) + 1));
                        }
                    }
                } else if (ballCount > 0 && map[i][j][0] > 0) {
                    move.add(fireballs.get(map[i][j][0] - 1));
                }
            }
        }

        return move;
    }

    private static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}